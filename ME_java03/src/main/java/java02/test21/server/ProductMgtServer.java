package java02.test21.server;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java02.test21.server.command.CommandMapping;
import java02.test21.server.command.CommandMapping.CommandInfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class ProductMgtServer {
  
  Scanner scanner; 
  ApplicationContext appCtx;
  CommandMapping commandMapping;

  public void init() throws Exception {
    
    scanner = new Scanner(System.in);
    
    appCtx = new ClassPathXmlApplicationContext(
        new String[]{"java02/test21/server/application-context.xml"});
    
    // objPool에서 @Command 애노테이션이 붙은 메서드를 찾는다.
    // 명령어와 메서드 연결 정보를 구축한다.
    commandMapping = new CommandMapping();
    commandMapping.prepare(appCtx.getBeansWithAnnotation(Component.class).values());
  }
  
  class ServiceThread extends Thread {
    Socket socket;
    Scanner in;
    PrintStream out;
    
    public ServiceThread(Socket socket) throws Exception {
      this.socket = socket;
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
    }
    
    private void parseQueryString(String query, HashMap<String,Object> map) {
      //예) query ==>  name=제품명&qty=20&mkno=6
      // ==> {"name=제품명","qty=20","mkno=6"}
      String[] entryList = query.split("&");
      String[] token = null;
      
      for (String entry : entryList) {
        token = entry.split("="); // 예)name=제품명
        map.put(token[0], token[1]);
      }
    }
    
    @Override
    public void run() {
      CommandInfo commandInfo = null;
      
      try {
        String[] token = in.nextLine().split("\\?");
        commandInfo = commandMapping.getCommandInfo(token[0]);
        
        if (commandInfo == null) {
          out.println("해당 명령을 지원하지 않습니다.");
          out.println(); //서버에서 더이상 데이터를 보낼 것이 없다는 표시
          return;
        }
        
        HashMap<String,Object> params = new HashMap<String,Object>();
        
        params.put("out", out);
        
        if (token.length > 1) {
          parseQueryString(token[1], params);
        }
        
        commandInfo.method.invoke(commandInfo.instance, params);
        
      } catch (Exception e) {
        e.printStackTrace();
        out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
        out.println();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  public void service() throws Exception {
    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = null;
    
    while (true) {
      socket = serverSocket.accept();
      new ServiceThread(socket).start();
    }
  }
  
  public void destroy() {
    scanner.close();
  }

  public static void main(String[] args) throws Exception {
    ProductMgtServer app = new ProductMgtServer();
    app.init();
    app.service();
    app.destroy();
  }

}





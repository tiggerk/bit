package java02.test05.commands;

import java.util.Map;
import java02.test05.Command;
import java02.test05.ScoreDao;

public class HelpCommand implements Command {

	@Override
	public String getCommandInfo() {
		return "help";
	}

	@Override
	public void service(Map<String, Object> params) throws Exception {
		ScoreDao scoreDao = (ScoreDao)params.get("scoreDao");
		System.out.println("list");
		System.out.println("view 인덱스");
		System.out.println("add 이름 국어 영어 수학");
		System.out.println("update 인덱스");
		System.out.println("exit");

	}

}

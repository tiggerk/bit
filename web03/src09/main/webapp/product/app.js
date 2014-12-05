var currPageNo;
var maxPageNo;

//$(document).ready(function(){});   //=> 아래랑 같은것
$(function(){
  $('.header').load('../common/header.html');
  $('.footer').load('../common/footer.html');
  $('.form').load('form.html');

  loadProductList(1);
  
  
  $(document).on('click', '.data-row a', function(){ // 현재 존재하는 태그 이외에 앞으로 존재할 태그에 대해서도!!
    loadProduct($(this).attr('data-no'));
  });
});


$('#prevBtn').click(function(event){
	if (currPageNo > 1) {
		loadProductList(currPageNo - 1);
	}
});

$('#nextBtn').click(function(event){
	if (currPageNo < maxPageNo) {
	  loadProductList(currPageNo + 1);
	} 
});

function setPageNo(currPageNo, maxPageNo) {
  window.currPageNo = currPageNo;
  window.maxPageNo = maxPageNo;
  
  $('#pageNo').html(currPageNo);
  
  if (currPageNo <= 1) $('#prevBtn').css('display', 'none');
  else $('#prevBtn').css('display', '');
  
  if (currPageNo >= maxPageNo) $('#nextBtn').css('display', 'none');
  else $('#nextBtn').css('display', '');
}

function loadProductList(pageNo){
  if (pageNo <= 0) pageNo = currPageNo;
  
	$.getJSON('../json/product/list.do?pageNo=' + pageNo,
    function(data){
		console.log(data);
		
      setPageNo(data.currPageNo, data.maxPageNo);
      var products = data.products;
      
      $('.data-row').remove();
      
      for (var i = 0; i < products.length; i++) {
        $('<tr>').addClass('data-row')
            .append($('<td>').html(products[i].no))
            .append(
            		$('<td>').append(
            				$('<a>').attr('href', '#')
            				        .attr('data-no', products[i].no)
            				        .html(products[i].name)
            		)
        		)
            .append($('<td>').html(products[i].quantity))
            .append($('<td>').html(products[i].maker))
            .appendTo('#productTable')
      }
    });
}




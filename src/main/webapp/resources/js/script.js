/**
 * 
 */

/*window.onload=function(){
setInterval(function(){document.getElementById("benvindo:btn-refresh").click();},1000);
}*/


function redirect(){
	if(document.forms['header']['header:tipo'][0].checked == true){

		document.location.href = 'basic.xhtml'
	}else if(document.forms['header']['header:tipo'][1].checked == true){
		document.location.href = 'scientific.xhtml'
	}
}


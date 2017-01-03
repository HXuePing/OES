<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath }/static/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript">

				function getGrade(){
					 var keyarray=new Array();
					 var answerarray=new Array();		
					var q="";
					var score=0;
					var r="";
					var rightanswercount=0;
					var aalength=document.getElementById("length").value;	
					for(var i=0;i<aalength;i++){
						//遍历答案
						keyarray[i]=document.getElementById(i+1+q).value;
						//遍历选中值的答案
						var radiocheckbox=document.getElementsByName(i+1+q);
								 for(var j=0;j<4;j++)
								 {
										if(radiocheckbox[j].checked==true)
										{
											r=radiocheckbox[j].value+r;					
										}									
									} 
						if(radiocheckbox[0].checked==false && radiocheckbox[1].checked==false &&radiocheckbox[2].checked==false&&radiocheckbox[3].checked==false){
							r=1+"";
						}						 
						 answerarray[i]=r;	
						 //答案与值进行判断
						 if(keyarray[i]== answerarray[i]){					
							 score=score+1;
							 r=""; //将r清0
							 rightanswercount=rightanswercount+1;
							 
						 }
					}		
					$("#score").val(score);			
					$("#rightcount").val(rightanswercount);			
					
					alert(score);
					alert(rightanswercount);
				}
				
				
			$(function(){	
				var checkSubmitFlg =true;
			
				$("#form").submit(function(){
					getGrade();
					if(window.confirm('你确定要提交试题吗？') && checkSubmitFlg){
						checkSubmitFlg =false;
						return true;
					}else{
						return false;
					}		
				/* 	$('input:radio').each(function(){				
						if($(this).prop('checked')==true){
							if(	$("#examTiKey").val()==$(this).val()){
								//console.log($("#examTiKey").val());
								 p=p+$(this).val();
								console.log(p+"ping"); 
							}
						}
					});
					
					$('input:checkbox').each(function(){
						if($(this).prop('checked')==true){
							//console.log($(this).val());
						}
		
					});
				 */
				
				/* 	var r="";
					for(var j=0;j<50;j++){
						var a="";
						var b=j+a;			
					var radio=document.getElementsByName(b);
					for(var i=0;i<radio.length;i++){
						if(radio[i].checked==true){
							r=radio[i].value;
							console.log(r);				
							}
						}
					} */
					/* var q="";
					var aaa=0;
					var r="";
					for(var i=1;i<20;i++){		
						var p=i+q;
						var key=document.getElementById(p);
						var radio=document.getElementsByName(p);
						//console.log(key.value);						
						 for(var j=0;j<radio.length;j++){
							if(radio[j].checked==true){
								r=radio[i].value;
								console.log(r);									
								}
							} 
						if(key.value==r){
							console.log("haha");	
						}
					}
					*/					
				});
				
		});	

			//时间倒计时
			/* var interval = 1000; 
			var leftsecond = parseInt(100000000); 		
			function ShowCountDown() 
			{ 
			var day1=Math.floor(leftsecond/(60*60*24)); 
			var hour=Math.floor((leftsecond-day1*24*60*60)/3600); 
			var minute=Math.floor((leftsecond-day1*24*60*60-hour*3600)/60); 
			var second=Math.floor(leftsecond-day1*24*60*60-hour*3600-minute*60); 
			var cc = document.getElementById("divdown1"); 
			cc.innerHTML =hour+"小时"+minute+"分"+second+"秒"; 
			leftsecond--;
			if(hour==00 && minute==00 && second==00){
				alert("考试结束");
				setTimeout(function(){
					alert("abcdefg");
					getGrade();
					alert("abcd");
					document.myform.submit();//自动提交表单
					},100);
				}
			} 
			window.setInterval(function(){ShowCountDown();}, interval); 
 */
		function gettime(){	  
			$.ajax({  					
					url:'/OES/student/getTimedemo',		
					type:'post', 
					dataType:'json',  
					 data:{time: 1000 },       
					error : function() {  
					        alert('Failed!');  
					 },  
					 success:function(json) {					    						    					    	
					        //用对象.属性的方式输出出来  			
							var cc = document.getElementById("divdown1"); 
							cc.innerHTML =json.h+"小时"+json.m+"分"+json.s+"秒";
							
							if(hour==0 && minute==0 && second==0){
								alert("考试结束");
								setTimeout(function(){									
									getGrade();									
									document.myform.submit();//自动提交表单
									},100);
								}
					    }  
					});  
 }
 window.setInterval(function(){gettime();},1000);
</script>
</head>
<body >
<div >
	<div style="text-align: center">考试题</div>   
    	&nbsp;&nbsp;剩余时间：<span id="divdown1"></span>  
	<br>	
	<form id="form" name="myform" action="${pageContext.request.contextPath }/student/checkscore" method="post"  >
	
	&nbsp;&nbsp;&nbsp;&nbsp;一、单选题<br>
	<c:forEach items="${examTi}" var="list" varStatus="on">
		<c:if test="${list.examTiType=='0'}">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${on.count}、
			${list.examTiName }<br>						
		<div id="div">		
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.<input type="radio" value="a" name="${on.count}" >${list.examTiOptiona}
		&nbsp;&nbsp;&nbsp;b.<input type="radio" value="b" name="${on.count}" >${list.examTiOptionb}
		&nbsp;&nbsp;&nbsp;c.<input type="radio" value="c" name="${on.count}" >${list.examTiOptionc}
		&nbsp;&nbsp;&nbsp;d.<input type="radio" value="d" name="${on.count}" >${list.examTiOptiond} 
		<input type="hidden" value="${list.examTiKey}" id="${on.count}">
		</div>
		
		<br>
		<br>
		</c:if>				
		<%-- <c:if test="${list.examTiType=='1'}">
			${on.count}、
			${list.examTiName }<br>
			a.<input type="checkbox" name="${on.count}" value="a">${list.examTiOptiona}
			b.<input type="checkbox" name="${on.count}" value="b">${list.examTiOptionb}
			c.<input type="checkbox" name="${on.count}" value="c">${list.examTiOptionc}
			d.<input type="checkbox" name="${on.count}" value="d">${list.examTiOptiond} 
			<input type="hidden" value="${list.examTiKey}" id="${on.count}">
		<br>
		<br>
		</c:if>	 --%>
		<input type="hidden" value="${examSubjectId}" name="examSubjectId" >			
	</c:forEach>
	
	&nbsp;&nbsp;&nbsp;&nbsp;二、多选题<br>
	<c:forEach items="${examTi}" var="list" varStatus="on">
		<%-- <c:if test="${list.examTiType=='0'}">
			${on.count}、
			${list.examTiName }<br>						
		<div id="div">		
		a.<input type="radio" value="a" name="${on.count}" >${list.examTiOptiona}
		b.<input type="radio" value="b" name="${on.count}" >${list.examTiOptionb}
		c.<input type="radio" value="c" name="${on.count}" >${list.examTiOptionc}
		d.<input type="radio" value="d" name="${on.count}" >${list.examTiOptiond} 
		<input type="hidden" value="${list.examTiKey}" id="${on.count}">
		</div>
		
		<br>
		<br>
		</c:if>		 --%>		
		<c:if test="${list.examTiType=='1'}">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${on.count}、
			${list.examTiName }<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a.<input type="checkbox" name="${on.count}" value="a">${list.examTiOptiona}
			&nbsp;&nbsp;&nbsp;b.<input type="checkbox" name="${on.count}" value="b">${list.examTiOptionb}
			&nbsp;&nbsp;&nbsp;c.<input type="checkbox" name="${on.count}" value="c">${list.examTiOptionc}
			&nbsp;&nbsp;&nbsp;d.<input type="checkbox" name="${on.count}" value="d">${list.examTiOptiond} 
			<input type="hidden" value="${list.examTiKey}" id="${on.count}">
		<br>
		<br>
		</c:if>	
		<%-- <input type="hidden" value="${examSubjectId}" name="examSubjectId" > --%>			
	</c:forEach>
	
	
	
	
		<input type="hidden" value="${length}" name="leng" id="length">
		<input type="hidden" value=""    name="sco" id="score" >
		<input type="hidden" value=""    name="rig" id="rightcount" >
		
 		<div >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"   value="提交试题"></div> 
 		
 		<a href="${ pageContext.request.contextPath }/login/index">主页</a>
	</form>
	</div>
</body>
</html>
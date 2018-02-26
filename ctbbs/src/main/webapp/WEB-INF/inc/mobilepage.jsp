<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/inc/taglibs.jsp"%>
<span>当前第${page.pagestart}页/总${page.totalPages}页</span>
   <c:if test="${page.pagestart!=1}">
	   <a href="javascript:;" onclick="topage(1)">首页</a> 
	   <a href="javascript:;" onclick="topage(${page.pagestart-1})">上一页</a> 
   </c:if>
	   <c:if test="${page.pagestart!=page.totalPages}">
		   <a href="javascript:;" onclick="topage(${page.pagestart+1})">下一页</a>
		   <a href="javascript:;" onclick="topage(${page.totalPages})">尾页</a> 
	   </c:if>
   <script type="text/javascript">
   function topage(pageno){
	   $("form").each(function(){
		  $(this).append('<input type="hidden" name="pagestart" value="'+pageno+'" />');
		  $(this).submit();
	   });
	   
   }
   </script>
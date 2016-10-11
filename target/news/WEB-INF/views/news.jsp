<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>News Page</title>
	<style type="text/css">
		.p1  {font-family: arial, verdana, sans-serif;font-size:16px;padding:0px 0px 0px 20px;font-weight:bold;}
		.p2  {font-family: arial, verdana, sans-serif;font-size:16px;padding:0px 0px 0px 20px;font-weight:bold;}
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}

	</style>
	<script type="text/javascript">
		function reloadPage()
		{
			window.location.reload()
		}
	</script>
</head>
<body>
<c:url var="addAction" value="/newses/add" ></c:url>
<c:url var="select" value="/newses/select" ></c:url>

		<div class="p1">NEWS FORM</div>


		<form:form action="${addAction}" commandName="news">
			<table>
					<c:if test="${!empty news.title}">
					<tr>
					<td>
					<form:label path="id">
					<spring:message text="ID"/>
					</form:label>
					</td>
					<td>
					<form:input path="id" readonly="true" size="8"  disabled="true" />
					<form:hidden path="id" />
					</td>
					</tr>
					</c:if>
					<tr>
				<td>
					<form:label path="title">
						<spring:message text="Title"/>
					</form:label>
				</td>
				<td>
					<form:input path="title" />
				</td>
				</tr>
				<tr>
					<td>
						<form:label path="content">
							<spring:message text="Content"/>
						</form:label>
					</td>
					<td>
						<form:input path="content" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="date">
							<spring:message text="Date"/>
						</form:label>
					</td>
					<td>
						<form:input path="date" />
					</td>
				</tr>
				<tr>
					<td>
						<form:label path="category">
							<spring:message text="Category"/>
						</form:label>
					</td>
					<td>
						<form:input path="category" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<c:if test="${!empty news.title}">
							<input type="submit"
								   value="<spring:message text="Edit Person"/>" />
						</c:if>
						<c:if test="${empty news.title}">
							<input type="submit"
								   value="<spring:message text="Add News"/>" />
						</c:if>
					</td>
				</tr>
			</table>
		</form:form>



<br>
<div class="p2">FILTER</div>


<form:form action="${select}" commandName="selector">
	<table>

			<td>
				<form:label path="title">
					<spring:message text="By title"/>
				</form:label>
			</td>
			<td>
				<form:input path="title" />
			</td>
		</tr>

		<tr>
			<td>
				<form:label path="content">
					<spring:message text="By content"/>
				</form:label>
			</td>
			<td>
				<form:input path="content" />
			</td>
		</tr>

		<tr>
			<td>
				<form:label path="category">
					<spring:message text="By category"/>
				</form:label>
			</td>
			<td>
				<form:input path="category" />
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit"
						   value="<spring:message text="Ok"/>" />
			</td>
			<td>
				<input type="button" value="Reset" onclick="reloadPage()" />
			</td>
		</tr>
	</table>
</form:form>

<br>

<br>
<div class="p1">NEWSLIST</div>
<c:if test="${!empty listNews}">
	<table class="tg">
		<tr>
			<th width="80"> ID</th>
			<th width="120">Title</th>
			<th width="120">Content</th>
			<th width="180">Date</th>
			<th width="120">Category</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listNews}" var="news">
			<tr>
				<td>${news.id}</td>
				<td>${news.title}</td>
				<td>${news.content}</td>
				<td>${news.date}</td>
				<td>${news.category}</td>
				<td><a href="<c:url value='/edit/${news.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/remove/${news.id}' />" >Delete</a></td>

			</tr>
		</c:forEach>
	</table>
</c:if>

</body>
</html>





</body>
</html>


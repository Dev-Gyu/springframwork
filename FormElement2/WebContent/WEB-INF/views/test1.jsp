<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="dataBean" action="result">
		<!-- form:option tag는 select태그의 path속성값과 매칭되는 커맨드객체의 멤버의 값을 selected로 정해줌 -->
		<form:select path="a1">
			<form:option value="data1">항목1</form:option>
			<form:option value="data2">항목2</form:option>
			<form:option value="data3">항목3</form:option>
		</form:select>
		<hr>
		<form:select path="a2">
			<form:options items="${requestScope.data_list1 }"></form:options>
		</form:select>
		<hr>
		<form:select path="a3">
			<form:options items="${requestScope.data_list2 }"/>
		</form:select>
		<hr>
		<form:select path="a4">
			<!-- itemLabel=태그 바디에 표시할 값을 가진 리스트멤버이름지정, itemValue=각 option태그들의 value값을 가진 리스트멤버이름지정 -->
			<form:options items="${requestScope.data_list3 }" itemLabel="key" itemValue="value"/>
		</form:select>
		<hr>
		
		
		<!-- checkbox = 커맨드객체에 path속성에 지정한 값에 해당하는 멤버의 값들 중 checkbox에 지정한 값이 있으면 checked지정해준다 -->
		<form:checkbox path="a5" value="data1"/>항목1
		<form:checkbox path="a5" value="data2"/>항목2
		<form:checkbox path="a5" value="data3"/>항목3
		<hr>
		<form:checkboxes items="${requestScope.data_list1 }" path="a6"/> <!-- 배열로 model객체 멤버 지정한경우 -->
		<hr>
		<form:checkboxes items="${requestScope.data_list2 }" path="a7"/> <!-- ArrayList로 model객체 멤버 지정한경우 -->
		<hr>
		<form:checkboxes items="${requestScope.data_list3 }" path="a8" itemLabel="key" itemValue="value"/> <!-- 태그 바디와 value값이 서로 다르게 표시되어야하는 경우 -->
		<hr>
		
		
		<form:radiobutton path="a9" value="data1"/>항목1
		<form:radiobutton path="a9" value="data2"/>항목2
		<form:radiobutton path="a9" value="data3"/>항목3
		<hr>
		<form:radiobuttons path="a10" items="${requestScope.data_list1 }"/>
		<hr>
		<form:radiobuttons path="a11" items="${requestScope.data_list2 }"/>
		<hr>
		<form:radiobuttons path="a12" items="${requestScope.data_list3 }" itemLabel="key" itemValue="value"/>
	</form:form>
</body>
</html>
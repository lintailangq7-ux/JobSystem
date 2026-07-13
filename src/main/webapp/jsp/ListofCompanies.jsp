<%@ page import="java.util.List" %>
<%@ page import="model.Company" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>企業一覧</title>
</head>
<body>

 <div class="top-area">
<button class="back-button" onclick="location.href='Login.html'">◀</button>

<h1>企業一覧</h1>
</div>
<form action="SearchServlet" method="get">

<input type="text" name="keyword" placeholder="企業名">

<button type="submit" class="search-btn">
🔍
</button>

</form>

<table border="1">
	<thead>
		<tr>
			<th>ID</th>
			<th>企業名</th>
			<th>住所</th>
			<th>TEL</th>
			<th>メールアドレス</th>
			<th>募集職種</th>
			<th>詳細</th>
		</tr>
		
	</thead>
	<tbody id="companyTable">
	<%
List<Company> list = 
    (List<Company>)request.getAttribute("companyList");

if(list != null){

    for(Company c : list){
%>
	
	
	<tr>
			    <td><%= c.getId() %></td>
			    <td><%= c.getName() %></td>
				<td><%= c.getAddress() %></td>
				<td><%= c.getTel() %></td>
				<td><%= c.getMail() %></td>
				<td><%= c.getJobtype() %></td>
			    <td class="menu-cell">
					
				    <button type="button" onclick="toggleActions(this)">詳細</button>
				    <div class="menu" style="display:none;">
				      <button type="button" onclick="alert('企業情報を変更しますか')">変更</button><br>
				      <button type="button" onclick="alert('企業情報を削除しますか')">削除</button>
				    </div>
				  
				 </td>
				 
				
				</tr>
				<%
    }
}
%>
				</tbody>
				
				


</table>
<button class="add-button" type="button" onclick="location.href=">追加</button>
<script>
function toggleActions(btn) {
    const actions = btn.nextElementSibling;

    if(actions.style.display === "none"){
        actions.style.display = "block";
    }else{
        actions.style.display = "none";
    }
}
</script>
</body>
</html>
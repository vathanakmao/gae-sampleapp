<%@include file="header.jsp"%>

<div class="row">
	<h3 class="title">Add Book</h3>
</div>

<form action="add" method="POST">
	<div class="row">
		<label>ID:</label> <input name="id"/>
	</div>
	<div class="row">
		<label>Title:</label> <input name="title"/>
	</div>
	<div class="row">
		<label>Author:</label> <input name="author"/>
	</div>
	<div class="row">
		<label>Year:</label> <input name="publishedYear"/>
	</div>
	<div class="row">
		<input type="submit" value="Submit" class="submit-button"/>
	</div>	
</form>
		
<%@include file="footer.jsp"%>
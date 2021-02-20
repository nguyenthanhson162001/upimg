<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Home/Home.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<br>
<h1>${address}</h1>

	<div id="content">
		<div class="container" style="margin-top: 10px;">
			<div class="row"
				style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
				<div class="col-sm-12">

					<h2 class="myclass">Status</h2>
					<form action="HomeController?action=add" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<label>ID</label> <input type="text" class="form-control"
								name="id" placeholder="Enter id">
						</div>
						<div class="form-group">
							<label>Full Name</label> <input type="text" class="form-control"
								name="name" placeholder="Enter name">
						</div>

						<div class="form-group">
							<label>Mặt trước</label> <br /> <input type="file"
								class="form-control" name="photo" placeholder="Enter photo" >
							<label>mặt sau</label> <br /> <input type="file"
								class="form-control" name="photo" placeholder="Enter photo">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-primary">Cancel</button>
					</form>
				</div>
			</div>
		</div>


		<c:forEach items="${List}" var="list">

			<div class="status">
				<div class="username">
					<span>${list.statusName}</span>
				</div>
				<div class="statusContent">
					<h5>${list.statusTitle}</h5>
					<p>${list.statusContent}</p>
					<img alt="" src="${list.statusImg}">
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
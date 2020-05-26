
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <form action="/add_product" method="get">
        <input type="hidden" name="id" value="${product.getId()}">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" value="${product.getName()}" >
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="text" class="form-control" name="price" id="price" value="${product.getPrice()}" >
        </div>
        <div class="form-group">
            <label for="amount">Amount</label>
            <input type="text" class="form-control" name="amount" id="amount" value="${product.getAmount()}">
        </div>
        <div class="form-group">
            <label for="color">Color</label>
            <input type="text" class="form-control" name="color" id="color" value="${product.getColor()}">
        </div>
        <div class="form-group">
            <label for="describes">Describes</label>
            <input type="text" class="form-control" name="describes" id="describes" value="${product.getDescribes()}">
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <select class="form-control" name="category" id="category" >
                <option value="iphone">iphone</option>
                <option value="samsung">samsung</option>
                <option value="bphone">bphone</option>
                <option value="vsmart">vsmart</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary" name="action" value="create">Create</button>
        <button type="submit" class="btn btn-primary" name="action" value="edit">Edit</button>
        <button type="submit" class="btn btn-primary" name="action" value="back" >Back</button>
    </form>
    <span>${message}</span>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<link href="<c:url value="/resources/css/css.css" />" rel="stylesheet">
<script src="/resources/js/jquery.js" type="text/javascript"></script>
<script src="/resources/js/app.js" type="text/javascript"></script>


</head>
<body>
    <h1 class="deepShadow">Hello stranger!</h1>

    <ul class="tabs">
    			<li id="knightLi"><a href="#knight">Knight</a></li>
    			<li id="inventoryLi"><a href="#inventory">Inventory</a></li>
    			<li id="shopLi"><a href="#shop">Shop</a></li>
    </ul>
    		<div class="content" id="knight">
    			<h3>Knight</h3>
    			<p>Knight here</p>
    		</div>
    		<div class="content" id="inventory">

     		</div>
    		<div class="content" id="shop">
    			<h3>Shop</h3>
    			<p>Shop here</p>
    		</div>


</body>
</html>

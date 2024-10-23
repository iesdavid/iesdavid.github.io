<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Mi primera pághina Web</title>
</head>
<body>

<h1>Hola Mundo <?= $_GET['password']?></h1>
<form action="" method="GET">
	<input type="password" name="password">
	<button>Enviar</button>
</form>
</body>
</html>
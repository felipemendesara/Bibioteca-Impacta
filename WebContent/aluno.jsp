<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Biblioteca - IMPACTA</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/datepicker3.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<link href="css/bootstrap-table.css" rel="stylesheet">


<!--Icons-->
<script src="js/lumino.glyphs.js"></script>

<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="AlunoController?action=teste"><span>Biblioteca</span>IMPACTA</a>
				<ul class="user-menu">
					<li class="dropdown pull-right">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg>Usu�rio<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li>
							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li>
							<li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
							
		</div><!-- /.container-fluid -->
	</nav>
		
		<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<ul class="nav menu">
		
		<li role="presentation" class="divider"></li>
			<li><a href="AlunoController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Aluno</a></li>
			<li><a href="AlunoController?action=listarAluno"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Alunos Cadastrados</a></li>
				
			<li role="presentation" class="divider"></li>


	<li role="presentation" class="divider"></li>
			<li><a href="ProfessorController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Professor</a></li>
			<li><a href="ProfessorController?action=listarProfessor"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Professores</a></li>
				
			<li role="presentation" class="divider"></li>
			
				<li role="presentation" class="divider"></li>
			<li><a href="LivroController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Livro</a></li>
			<li><a href="LivroController?action=listarLivro"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Livros</a></li>
				
			<li role="presentation" class="divider"></li>
				<li><a href="UsuarioController?action=insert"><svg class="glyph landed books"><use xlink:href="#stroked-pencil"></use></svg> Cadastrar Usu�rio</a></li>
			<li><a href="UsuarioController?action=listarUsuario"><svg class="glyph stroked table"><use xlink:href="#stroked-table"/></svg> Listar Usu�rio</a></li>
			
		</ul>

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#"><svg class="glyph stroked home"><use xlink:href="#stroked-home"></use></svg></a></li>
				<li class="active">Icons</li>
			</ol>
		</div><!--/.row-->
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">Aluno</div>
					<div class="panel-body">
						    <form action="AlunoController" method="post">
        <fieldset>
            <div>
           
                 <input class="form-control" type="text"
                    name="alunoId" value="<c:out value="${aluno.alunoId}" />"
                    readonly="readonly" placeholder="Id Aluno..." style="visibility: hidden;"/>
            </div>
            <div>
                <label for="nomeAluno">Nome do aluno</label> 
                <input class="form-control" type="text"
                    name="nomeAluno" value="<c:out value="${aluno.nomeAluno}" />"
                    placeholder="Digite o nome do aluno..." />
            </div>
            <div>
                <label for="ra">RA</label> 
                <input class="form-control" type="text"
                    name="ra" value="<c:out value="${aluno.RA}" />"
                    placeholder="Digite o RA do aluno..." />
            </div>
            <div>
                <label for="senha">Senha</label> 
                <input class="form-control" type="password" name="senha"
                    value="<c:out value="${aluno.senha}" />" placeholder="Digiteo a senha do aluno..." />
            </div>
            <div>
                <label for="idade">idade</label> <input class="form-control" type="text" name="idade"
                    value="<c:out value="${student.idade}" />" placeholder="Digite a idade do aluno" />
            </div>
            <br>	
            <div>
                <input class="btn btn-primary" style="width:100%" type="submit" value="Cadastrar Aluno" />
            </div>
        </fieldset>
    </form>
					</div>
				</div>
			</div>
		</div><!--/.row-->	
		
				</div>
								
			</div><!--/.col-->
		</div><!--/.row-->
	</div>	<!--/.main-->

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		$('#calendar').datepicker({
		});

		!function ($) {
		    $(document).on("click","ul.nav li.parent > a > span.icon", function(){          
		        $(this).find('em:first').toggleClass("glyphicon-minus");      
		    }); 
		    $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>

</html>


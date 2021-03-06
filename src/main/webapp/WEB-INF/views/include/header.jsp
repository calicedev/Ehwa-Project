<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
@font-face {
	font-family: 'Hahmlet-Bold';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2110@1.0/Hahmlet-Bold.woff2')
		format('woff2');
	font-weight: normal;
	font-style: normal;
}

body {
	font-size: .875rem;
	font-family: 'Hahmlet-Bold';
}

.feather {
	width: 16px;
	height: 16px;
	vertical-align: text-bottom;
}

/*
	 * Sidebar
	 */
.sidebar {
	position: fixed;
	top: 0;
	/* rtl:raw:
	  right: 0;
	  */
	bottom: 0;
	/* rtl:remove */
	left: 0;
	z-index: 100; /* Behind the navbar */
	padding: 48px 0 0; /* Height of navbar */
	box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
}

@media ( max-width : 767.98px) {
	.sidebar {
		top: 5rem;
	}
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: .5rem;
	overflow-x: hidden;
	overflow-y: auto;
	/* Scrollable contents if viewport is shorter than content. */
}

.sidebar .nav-link {
	font-weight: 500;
	color: #333;
}

.sidebar .nav-link .feather {
	margin-right: 4px;
	color: #727272;
}

.sidebar .nav-link.active {
	color: #2470dc;
}

.sidebar .nav-link:hover .feather, .sidebar .nav-link.active .feather {
	color: inherit;
}

.sidebar-heading {
	font-size: .75rem;
	text-transform: uppercase;
}

.navbar-brand {
	padding-top: .75rem;
	padding-bottom: .75rem;
	font-size: 1rem;
	background-color: rgba(0, 0, 0, .25);
	box-shadow: inset -1px 0 0 rgba(0, 0, 0, .25);
}

.navbar .navbar-toggler {
	top: .25rem;
	right: 1rem;
}

.navbar .form-control {
	padding: .75rem 1rem;
	border-width: 0;
	border-radius: 0;
}

.form-control-dark {
	color: #fff;
	background-color: rgba(255, 255, 255, .1);
	border-color: rgba(255, 255, 255, .1);
}

.form-control-dark:focus {
	border-color: transparent;
	box-shadow: 0 0 0 3px rgba(255, 255, 255, .25);
}

.dropdown-toggle {
	outline: 0;
}

.nav-flush .nav-link {
	border-radius: 0;
}

.b-example-divider {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.bi {
	vertical-align: -.125em;
	pointer-events: none;
	fill: currentColor;
}

.btn-toggle {
	display: inline-flex;
	align-items: center;
	padding: .25rem .5rem;
	font-weight: 600;
	color: rgba(0, 0, 0, .65);
	background-color: transparent;
	border: 0;
}

.btn-toggle:hover, .btn-toggle:focus {
	color: rgba(0, 0, 0, .85);
	background-color: #d2f4ea;
}

.btn-toggle::before {
	width: 1.25em;
	line-height: 0;
	content:
		url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' width='16' height='16' viewBox='0 0 16 16'%3e%3cpath fill='none' stroke='rgba%280,0,0,.5%29' stroke-linecap='round' stroke-linejoin='round' stroke-width='2' d='M5 14l6-6-6-6'/%3e%3c/svg%3e");
	transition: transform .35s ease;
	transform-origin: .5em 50%;
}

.btn-toggle[aria-expanded="true"] {
	color: rgba(0, 0, 0, .85);
}

.btn-toggle[aria-expanded="true"]::before {
	transform: rotate(90deg);
}

.btn-toggle-nav a {
	display: inline-flex;
	padding: .1875rem .5rem;
	margin-top: .125rem;
	margin-left: 1.25rem;
	text-decoration: none;
}

.btn-toggle-nav a:hover, .btn-toggle-nav a:focus {
	background-color: #d2f4ea;
}

.scrollarea {
	overflow-y: auto;
}

.fw-semibold {
	font-weight: 600;
}

.lh-tight {
	line-height: 1.25;
}

.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>
<body>


	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/">?????? ?????? Project</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">??????</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="list-unstyled ps-0">
						<li class="mb-1">
							<button
								class="btn btn-toggle align-items-center rounded collapsed"
								data-bs-toggle="collapse" data-bs-target="#dashboard-collapse"
								aria-expanded="true">Dashboard</button>
							<div class="collapse show" id="dashboard-collapse">
								<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">

									<li><a href="/board/list" class="link-dark rounded">????????????</a></li>
									<li><a href="/board/theme" class="link-dark rounded">?????????
											????????????</a></li>
								</ul>
							</div>
						</li>
						<li class="border-top my-3"></li>
						<li class="mb-1">
							<button
								class="btn btn-toggle align-items-center rounded collapsed"
								data-bs-toggle="collapse" data-bs-target="#account-collapse"
								aria-expanded="true">Account</button>
							<div class="collapse show" id="account-collapse">
								<ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
									<c:choose>
									<%-- 	<c:when test="${null == memberDTO}"> --%>
									<c:when test="${null == localStorage.getItem('time')}">
											<li><a href="/member/loginbtn" class="link-dark rounded">Login</a></li>
											<li><a href="/member/signupbtn"class="link-dark rounded">Sign up</a></li>
											<li><a class="link-dark rounded" id="sessionstorage">${sessionStorage.getItem("email")}???</a></li>
										</c:when>

										<c:otherwise>
											<li><a class="link-dark rounded">${sessionScope.loginId}???</a></li>
											<li><a href="/board/friendadd" class="link-dark rounded">??????</a></li>
											<li><a href="/board/myanswer" class="link-dark rounded">?????? ??????</a></li>
											<li>
												<form action="/member/logout" method="get">
													<button class=" link-dark rounded"
														style="margin-left: 25px; margin-top: 5px" type="submit"
														value="LOGOUT">????????????</button>
												</form>
											</li>

										</c:otherwise>
									</c:choose>
								</ul>
							</div>
						</li>
					</ul>

				</div>
			</nav>
			<br>
		</div>
	</div>



	<script>
      /* global bootstrap: false */
      (function () {
        'use strict'
        var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
        tooltipTriggerList.forEach(function (tooltipTriggerEl) {
          new bootstrap.Tooltip(tooltipTriggerEl)
        })
      })()
      
      $(window).on('load', function() {
    	  var session_email =sessionStorage.getItem("email");
    	  $('#sessionstorage').text(session_email);
	});
      function getItemWithExpireTime(keyName) {
			  
			  // localStorage ??? ?????? (?????????)
			  const objString = window.localStorage.getItem(keyName);
			  
			  // null ??????
			  if(!objString) {
			    return null;
			  }
			  
			  // ???????????? ????????? ??????
			  const obj = JSON.parse(objString);
			  
			  // ?????? ????????? localStorage??? expire ?????? ??????
			  if(Date.now() > obj.expire) {
			    // ??????????????? ?????? item ??????
			    window.localStorage.removeItem(keyName); 
			    alert("?????????");
			    // null ??????
			    return null;
			  }
			 
			  // ??????????????? ???????????? ??????, value ??? ??????
			  return obj.value;
			}
      

      window.onload = function(){
    	  getItemWithExpireTime("time");
      }

      </script>
</body>
</html>

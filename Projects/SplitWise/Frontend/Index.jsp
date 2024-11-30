<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<div id="home">
<img src="${pageContext.request.contextPath}/images/home.jpg" id="home"/>
</div>
<div id="new" align="center">
<div class="container" >
    <div class="heading">Login</div>
    <form action="" class="form">
      <input required="" class="input" type="email" name="email" id="email" placeholder="Username">
      <input required="" class="input" type="password" name="password" id="password" placeholder="Password">
      <span class="forgot-password"><a href="#">Forgot Password ?</a></span>
      <input class="login-button" type="submit" value="Login">
      
    </form>
    <div class="social-account-container">
        <span class="title">Don't have account? </span> 
        
      </div>
      
  </div>
  
</div>

</body>
</html>
<style>

#new
{
	position: relative;
        
        bottom:930px;
}
/* From Uiverse.io by Smit-Prajapati */
.container {
  z-index: 1;
  max-width: 350px;
  background: #F8F9FD;
  background: linear-gradient(0deg, rgb(255, 255, 255) 0%, rgb(244, 247, 251) 100%);
  border-radius: 40px;
  padding: 25px 35px;
  border: 5px solid rgb(255, 255, 255);
  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 30px 30px -20px;
  margin: 20px;
  width: 100%; /* Ensure full width on small screens */
  box-sizing: border-box;
}

.heading {
  text-align: center;
  font-weight: 900;
  font-size: 30px;
  color: rgb(16, 137, 211);
}

/* Form styling */
.form {
  margin-top: 20px;
}

.form .input {
  width: 100%;
  background: white;
  border: none;
  padding: 15px 20px;
  border-radius: 20px;
  margin-top: 15px;
  box-shadow: #cff0ff 0px 10px 10px -5px;
  border-inline: 2px solid transparent;
}

.form .input::-moz-placeholder {
  color: rgb(170, 170, 170);
}

.form .input::placeholder {
  color: rgb(170, 170, 170);
}

.form .input:focus {
  outline: none;
  border-inline: 2px solid #12B1D1;
}

.form .forgot-password {
  display: block;
  margin-top: 10px;
  margin-left: 10px;
}

.form .forgot-password a {
  font-size: 11px;
  color: #0099ff;
  text-decoration: none;
}

.form .login-button {
  display: block;
  width: 100%;
  font-weight: bold;
  background: linear-gradient(45deg, rgb(16, 137, 211) 0%, rgb(18, 177, 209) 100%);
  color: white;
  padding-block: 15px;
  margin: 20px auto;
  border-radius: 20px;
  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 20px 10px -15px;
  border: none;
  transition: all 0.2s ease-in-out;
}

.form .login-button:hover {
  transform: scale(1.03);
  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 23px 10px -20px;
}

.form .login-button:active {
  transform: scale(0.95);
  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 15px 10px -10px;
}

.social-account-container {
  margin-top: 25px;
}

.social-account-container .title {
  display: block;
  text-align: center;
  font-size: 10px;
  color: rgb(170, 170, 170);
}

.social-account-container .social-accounts {
  width: 100%;
  display: flex;
  justify-content: center;
  gap: 15px;
  margin-top: 5px;
}

.social-account-container .social-accounts .social-button {
  background: linear-gradient(45deg, rgb(0, 0, 0) 0%, rgb(112, 112, 112) 100%);
  border: 5px solid white;
  padding: 5px;
  border-radius: 50%;
  width: 40px;
  aspect-ratio: 1;
  display: grid;
  place-content: center;
  box-shadow: rgba(133, 189, 215, 0.8784313725) 0px 12px 10px -8px;
  transition: all 0.2s ease-in-out;
}

.social-account-container .social-accounts .social-button .svg {
  fill: white;
  margin: auto;
}

.social-account-container .social-accounts .social-button:hover {
  transform: scale(1.2);
}

.social-account-container .social-accounts .social-button:active {
  transform: scale(0.9);
}

.agreement {
  display: block;
  text-align: center;
  margin-top: 15px;
}

.agreement a {
  text-decoration: none;
  color: #0099ff;
  font-size: 9px;
}

/* Media Queries for Responsiveness */

/* For devices like tablets */
@media (max-width: 768px) {
  .container {
    padding: 20px;
    max-width: 90%; /* Allow form to take up more width */
  }

  .heading {
    font-size: 24px;
  }

  .form .input {
    padding: 12px 18px;
  }

  .form .login-button {
    padding-block: 12px;
  }

  .social-account-container .social-accounts {
    gap: 10px; /* Adjust spacing between buttons */
  }
}

/* For small devices (mobile phones) */
@media (max-width: 480px) {
  .container {
    padding: 15px;
    max-width: 95%;
  }

  .heading {
    font-size: 20px;
  }

  .form .input {
    padding: 10px 15px;
  }

  .form .login-button {
    padding-block: 10px;
  }

  .social-account-container .social-accounts {
    gap: 8px; /* Further reduce button gap */
  }

  .agreement a {
    font-size: 8px;
  }
}

/* For extra small devices (very small phones or portrait mode) */
@media (max-width: 360px) {
  .container {
    padding: 10px;
    max-width: 100%; /* Allow form to take up entire width */
  }

  .heading {
    font-size: 18px;
  }

  .form .input {
    padding: 8px 12px;
  }

  .form .login-button {
    padding-block: 8px;
  }

  .social-account-container .social-accounts {
    gap: 6px; /* Further reduce button gap */
  }

  .agreement a {
    font-size: 7px;
  }
}

#home {
  width: 100%;
  height: auto;
  display: block;
  max-width: 100%;
  filter: brightness(0.5);
}


</style>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Edit an Employee</title>
    <link rel="icon" type="image/png" href="LG.png" />
   
    <!-- Google Font: Source Sans Pro -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
    />
    <!--
    <!-- Google Font: Source Sans Pro -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback"
    />
    <!-- Font Awesome Icons -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css" />
    <!-- overlayScrollbars -->
    <link
      rel="stylesheet"
      href="plugins/overlayScrollbars/css/OverlayScrollbars.min.css"
    />
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css" />
   
    
      <!-- Google Font: Source Sans Pro -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
      <!-- Theme style -->
      <link rel="stylesheet" href="dist/css/adminlte.min.css">
    </head>
    <script>
      function changePlaceholder(input) {
          input.setAttribute("placeholder", "");
      }
  </script>
  
    <body class="hold-transition sidebar-mini">
         <% 
     Boolean Ine = null;
     try {
         Ine = (Boolean) session.getAttribute("loggedIn");
     } catch (Exception e) {
         // Handle the exception, such as printing the stack trace
     }
     if (Ine == null || !Ine) {
         response.sendRedirect("../Login.jsp");
     }

%>
      <div class="wrapper">
        <!-- Preloader -->
        <div class="preloader flex-column justify-content-center align-items-center">
          <img class="animation__wobble" src="LG.png" alt="AdminLTELogo" height="60" width="60">
        </div>
        <%@ include file="navbar.jsp"%> 
        <%@ include file="sidebar.jsp"%>
        <%@ page import="manage.dao.*"%>
        <%@ page import="entities.Employee"%>
       <%@ page import="entities.User" %>
        
       <% 
           EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
           
           String i=(String)  request.getAttribute("intedit");
           int e= Integer.parseInt(i);
           Employee employee= (Employee) employeeDAO.getEmployeeById(e);
           User u=employee.getUser();
           
            %>
    
                <!-- Content Wrapper. Contains page content -->
                <div class="content-wrapper">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                      <div class="container-fluid">
                        <div class="row mb-2">
                          <div class="col-sm-6">
                            <h1>Edit an Employee</h1>
                          </div>
                          <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                              <li class="breadcrumb-item"><a href="#">Home</a></li>
                              <li class="breadcrumb-item active">General Form</li>
                            </ol>
                          </div>
                        </div>
                      </div><!-- /.container-fluid -->
                    </section>

                    <!-- Main content -->
                    <section class="content">
                      <div class="container-fluid">
                        <div class="row">
                          <!-- left column -->
                          <div class="col-md-6">
                            <!-- general form elements -->
                            <section style=" padding: 0px; margin: 0px; width: 1050px;">
                                <div class="card card-primary w-100">
                                  <div class="card-header w-100">
                            
                                <h3 class="card-title">Quick Edit</h3>
                              </div>
                              <!-- /.card-header -->
                              <!-- form start -->
                              <form action="./EditEmployeeServlet?upd=<%=i %>" method="post">
                                <div class="card-body">
								    <div class="form-group">
								        <label for="code">Employee Code</label>
								        <input type="text" class="form-control" id="code" name="code" placeholder="Employee Code" value="<%=employee.getCode()%>">
								    </div>
								                                                                  
								    <div class="form-group">
								        <label for="firstName">First Name</label>
								        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name" value="<%=employee.getFirstName()%>">
								    </div>
								
								    <div class="form-group">
								        <label for="lastName">Last Name</label>
								        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name" value="<%=employee.getLastName()%>">
								    </div>
								
								    <div class="form-group">
								        <label for="date">Date of Birth</label>
								        <input type="date" class="form-control" id="date" name="date" value="<%=employee.getDateOfBirth()%>"> 
								        <span id="dateOfBirthError" style="color: red; display: none;">Please enter your date of birth</span>
								    </div>
								
								    <div class="form-group">
								        <label for="phoneNumber">Phone Number</label>
								        <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" value="<%=employee.getPhoneNumber()%>">
								    </div>
								
								    <div class="form-group">
								        <label for="address">Address</label>
								        <input type="text" class="form-control" id="address" name="address" placeholder="Address" value="<%=employee.getAddress()%>">
								    </div>
								                                   
								    <div class="form-group">
								        <label for="ESI">Employee State Insurance (No. ESI)</label>
								        <input type="text" class="form-control" id="ESI" name="ESI" placeholder="ESI" value="<%=employee.getEsiNumber()%>">
								    </div>
								                                    
								    <div class="form-group">
								        <label for="position">Position</label>
								        <input type="text" class="form-control" id="position" name="position" placeholder="position" value="<%=employee.getPosition()%>">
								    </div>
								                                    
								    <div class="form-group">
								        <label for="accountNumber">Account Number</label>
								        <input type="text" class="form-control" id="accountNumber" name="accountNumber" placeholder="accountNumber" value="<%=employee.getAccountNumber()%>">
								    </div>
								                                    
								    <div class="form-group">
								        <label for="salnet">Net Salary</label>
								        <input type="text" class="form-control" id="salnet" name="salnet" placeholder="salnet" value="<%=employee.getSalnet()%>">
								    </div>
								    
								    <div class="form-group">
								        <label for="paymentMode">Payment Mode</label>
								        <select class="form-control" id="paymentMode" name="paymentMode">
								            <option value="Cash">Cash</option>
								            <option value="Cheque">Cheque</option>
								            <option value="Bank Transfer">Bank Transfer</option>
								            <option value="Credit Card">Credit Card</option>
								            <option value="Debit Card">Debit Card</option>
								            <option value="Direct Deposit">Direct Deposit</option>
								            <option value="Online Payment Services">Online Payment Services</option>
								            <option value="Mobile Payment">Mobile Payment</option>
								            <option value="Cryptocurrency">Cryptocurrency</option>
								            <option value="Salary">Salary</option>
								        </select>
								    </div>
                            <Style>
                            .small-image {
                                                    width: 200px; /* Adjust the width as per your requirement */
                                                    height: auto;
                                                    padding :20px; /* Maintain aspect ratio */
                                                }
                                                </style>      
                                    <div class="form-group">
                                        <label for="file">Photo</label>
                                        <img class="small-image" src="<%=employee.getPhoto()%>" alt="<%=employee.getFirstName()+""+employee.getLastName()%>">
                                        <input type="file" class="form-control-file" id="file" name="file" value="" oninput="changePlaceholder(this)">
                                    </div>
                            
                                    <div class="form-group">
                                        <label for="maritalStatus">Marital Status</label>
                                        <select class="form-control" id="maritalStatus" name="maritalStatus" value="<%=employee.getMaritalStatus()%>" oninput="changePlaceholder(this)">
                                            <option value="Single">Single</option>
                                            <option value="Married">Married</option>
                                            
                                            <option value="Widowed">Widowed</option>
                                            <option value="Divorced">Divorced</option>
                                        </select>
                                    </div>

                                    <div class="form-group">
                                      <label for="email">Email</label>
                                      <div class="input-group">
                                          <div class="input-group-prepend">
                                              <span class="input-group-text"><i class="bi bi-envelope"></i></span>
                                          </div>
                                          <input type="email" class="form-control" id="email" name="email" placeholder="Email" value="<%=employee.getMail()%>" oninput="changePlaceholder(this)">
                                      </div>
                                  </div>
                          
                                  <div class="form-group">
                                      <label for="password">Password</label>
                                      <div class="input-group">
                                          <div class="input-group-prepend">
                                              <span class="input-group-text"><i class="bi bi-lock"></i></span>
                                          </div>
                                          <input type="password" class="form-control" id="password" name="password" placeholder="Password" value="<%=u.getPassword()%>" oninput="changePlaceholder(this)">
                                      </div>
                                  </div>
                          
                                  <div class="form-group">
                                      <label for="confirmPassword">Confirm Password</label>
                                      <div class="input-group">
                                          <div class="input-group-prepend">
                                              <span class="input-group-text"><i class="bi bi-lock"></i></span>
                                          </div>
                                          <input type="password" class="form-control" id="confirmPassword" placeholder="Confirm Password" value="<%=u.getPassword()%>" oninput="changePlaceholder(this)">
                                      </div>
                                  </div>
                              </div>
                              <!-- /.card-body -->
                                                      
                              <div class="card-footer">
                                <button type="submit" class="btn btn-primary"><i class="bi bi-check-circle"></i>Edit</button>
                              </div>
                             </form>
                            
                            
                            </div>
                            </section>
                            <!-- /.card -->
                    
                              
                    
                                
                            </div>
                            <!-- /.row -->
                          </div><!-- /.container-fluid -->
                          
                        </section>
                        <!-- /.content -->
      </div>                  
      <script>
        function validateForm() {
    var dateOfBirthInput = document.getElementById('dateOfBirth');
    var dateOfBirthError = document.getElementById('dateOfBirthError');

    // Check if the date of birth field is empty
    if (!dateOfBirthInput.value) {
        dateOfBirthError.style.display = 'block';
        return false; // Prevent form submission
    } else {
        dateOfBirthError.style.display = 'none';
        // Proceed with form submission
        // You can add additional validation or form submission logic here
    }
}
        document.getElementById("employeeForm").addEventListener("submit", function(event) {
          validateForm();
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirmPassword").value;
    
            if (password.length < 8) {
                alert("Password must be at least 8 characters long.");
                event.preventDefault();
            } else if (password !== confirmPassword) {
                alert("Passwords do not match.");
                event.preventDefault();
            }
        });
    </script>               
    <!-- jQuery -->
    <script src="../../plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- bs-custom-file-input -->
    <script src="../../plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
    <!-- AdminLTE App -->
    <script src="../../dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
  
        <script src="plugins/jquery/jquery.min.js"></script>
        <!-- jQuery UI 1.11.4 -->
        <script src="plugins/jquery-ui/jquery-ui.min.js"></script>
        <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
        <script>
          $.widget.bridge('uibutton', $.ui.button)
        </script>
        <!-- Bootstrap 4 -->
        <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- ChartJS -->
        <script src="plugins/chart.js/Chart.min.js"></script>
        <!-- Sparkline -->
        <script src="plugins/sparklines/sparkline.js"></script>
        <!-- JQVMap -->
        <script src="plugins/jqvmap/jquery.vmap.min.js"></script>
        <script src="plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
        <!-- jQuery Knob Chart -->
        <script src="plugins/jquery-knob/jquery.knob.min.js"></script>
        <!-- daterangepicker -->
        <script src="plugins/moment/moment.min.js"></script>
        <script src="plugins/daterangepicker/daterangepicker.js"></script>
        <!-- Tempusdominus Bootstrap 4 -->
        <script src="plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
        <!-- Summernote -->
        <script src="plugins/summernote/summernote-bs4.min.js"></script>
        <!-- overlayScrollbars -->
        <script src="plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
        <!-- AdminLTE App -->
        <script src="dist/js/adminlte.js"></script>
        
        
        <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
        <script src="dist/js/pages/dashboard.js"></script>
        <%@ include file="footer.jsp"%></body>
    </html>
      
 
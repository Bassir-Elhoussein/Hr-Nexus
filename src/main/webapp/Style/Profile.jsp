<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="manage.dao.*" %> 
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page import="entities.Employee" %>
 <%@page import="test.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>List of Employees</title>
    <link rel="icon" type="image/png" href="LG.png" />
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Font Awesome icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">
</head>
<body
class="hold-transition sidebar-mini"
      >
     <% 
     Boolean In = null;
     try {
         In = (Boolean) session.getAttribute("loggedIn");
     } catch (Exception e) {
         // Handle the exception, such as printing the stack trace
     }
     if (In == null || !In) {
         response.sendRedirect("../Login.jsp");
     }

%>
      
      
      
      <script>
        function redirectToProfile(employeeID) {
          // Redirect to the employee profile page with the employee ID
          window.location.href = "./DeleteEmployeeServlet?a=" + employeeID;
        }
        function editEmployee(employeeID) {
            // Redirect to the employee profile page with the employee ID
            window.location.href = "./EditEmployeeServlet?e=" + employeeID;
          }
          
          function redirectToPayslip(employeeID) {
            // Redirect to the employee profile page with the employee ID
            window.location.href = "./Payslip?ps=" + employeeID;
          }
          function CalendarEmployee(employeeID) {
            // Redirect to the employee profile page with the employee ID
            window.location.href = "./EventServlet?c=" + employeeID;
          }
      </script>
      <body class="hold-transition sidebar-mini" >
        <div class="wrapper">
            <!--  Preloader -->
            <div class="preloader flex-column justify-content-center align-items-center">
                <img class="animation__wobble" src="LG.png" alt="AdminLTELogo" height="60" width="60">
            </div>
            <%@ include file="navbar.jsp"%>
            <%@ include file="sidebar.jsp"%>
            <%@ page import="entities.Employee"%>
            <%@ page import="entities.Employee" %>
    

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1>Profile</h1>
          </div>
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">User Profile</li>
            </ol>
          </div>
        </div>
      </div><!-- /.container-fluid -->
    </section>

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <div class="row-cols-lg-1 ">
          <div class="col-md-3 ">
            <!-- Profile Image -->
           <% 
           EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
           
           String i=(String)  request.getAttribute("int");
           String img=(String)  request.getAttribute("image");
           int e= Integer.parseInt(i);
           Employee employee= (Employee) employeeDAO.getEmployeeById(e);
           
           
            %>
                <div class="card card-primary card-outline">
                    <div class="card-body box-profile">
                    <div class="text-center">
                        <img class="profile-user-img img-fluid img-circle"
                            src="<%= img%>" alt="User profile picture"
                            >
                    </div>
                
                    <h3 class="profile-username text-center"><%= employee.getFirstName() + " " + employee.getLastName() %></h3>
                
                    <p class="text-muted text-center"><%=employee.getPosition()%></p>
                
                    <ul class="list-group list-group-unbordered mb-3">
							    <li class="list-group-item">
							        <b>Address</b> <span class="float-right"><%= employee.getAddress() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Date of Birth</b> <span class="float-right"><%= employee.getDateOfBirth() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Marital Status</b> <span class="float-right"><%= employee.getMaritalStatus() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Email</b> <span class="float-right"><%= employee.getMail() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Phone Number</b> <span class="float-right"><%= employee.getPhoneNumber() %></span>
							    </li>
							    <!-- Add additional attributes here -->
							    <li class="list-group-item">
							        <b>Employee State Insurance</b> <span class="float-right"><%= employee.getEsiNumber()%></span>
							    </li>
							    <li class="list-group-item">
							        <b>Position</b> <span class="float-right"><%= employee.getPosition() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Account Number</b> <span class="float-right"><%= employee.getAccountNumber() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Net Salary</b> <span class="float-right"><%= employee.getSalnet() %></span>
							    </li>
							    <li class="list-group-item">
							        <b>Payment Mode</b> <span class="float-right"><%= employee.getPaymentMode() %></span>
							    </li>
							</ul>

                
                    
                    <div class="row justify-content-center mt-3">
                      <div class="col-sm-6 text-center">
                          <a href="./EmployeeServlet" class="btn btn-secondary mr-2">
                              <i class="fas fa-chevron-left"></i> Back to Employee List
                          </a>
                          <a href="#" class="btn btn-warning" onclick="editEmployee('<%= employee.getEmployeeID() %>')">
                            <i class="fas fa-edit"></i> Edit
                        </a>
                         <a href="#" class="btn btn-danger" onclick="CalendarEmployee('<%= employee.getEmployeeID() %>')">
                            <i class="fas fa-edit"></i> Calendar
                        </a>
                        <a href="#" class="btn btn-success" onclick="redirectToPayslip('<%= employee.getEmployeeID() %>')">
                            $ Print Payslip
                        </a>
                          <a href="#" class="btn btn-primary" onclick="redirectToProfile('<%= employee.getEmployeeID() %>')">
                              <b>Delete</b>
                          </a>
                          
                         
                      </div>
                     </div>
                  </div>
                    <!-- /.card-body -->
                </div>
  
            <!-- /.card -->

            <!-- About Me Box -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">About Me</h3>
              </div>
              <!-- /.card-header -->
              <div class="card-body">
                <strong><i class="fas fa-book mr-1"></i> Education</strong>

                <p class="text-muted">
                  B.S. in Computer Science from the University of Tennessee at Knoxville
                </p>

                <hr>

                <strong><i class="fas fa-map-marker-alt mr-1"></i> Location</strong>

                <p class="text-muted">Malibu, California</p>

                <hr>

                <strong><i class="fas fa-pencil-alt mr-1"></i> Skills</strong>

                <p class="text-muted">
                  <span class="tag tag-danger">UI Design</span>
                  <span class="tag tag-success">Coding</span>
                  <span class="tag tag-info">Javascript</span>
                  <span class="tag tag-warning">PHP</span>
                  <span class="tag tag-primary">Node.js</span>
                </p>

                <hr>

                <strong><i class="far fa-file-alt mr-1"></i> Notes</strong>

                <p class="text-muted">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
          <!-- /.col -->
          
          <!-- /.col -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  

</div>
<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- DataTables  & Plugins -->
<script src="plugins/datatables/jquery.dataTables.min.js"></script>
<script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
<script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
<script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
<script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
<script src="plugins/jszip/jszip.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- Bootstrap JS (optional) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%@ include file="footer.jsp"%>
</body>
</html>

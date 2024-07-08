<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="manage.dao.*" %> 
<%@page import="java.util.List" %>
<%@page import="java.util.Date" %>

<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>List of Employees</title>
    <link rel="icon" type="image/png" href="LG.png" />

    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
    <script>
        function redirectToProfile(employeeID) {
          // Redirect to the employee profile page with the employee ID
          window.location.href = "./Profile?q=" + employeeID;
        }
      </script>
    <style>
        /* Add hover effect */
        #example1 tbody tr:hover {
          background-color: #00a2ff38;
          cursor: pointer;
        }
        
        /* Add on-click effect */
        #example1 tbody tr.clicked {
          background-color: #f14d4d;
        }
      </style>
</head>
<body
class="hold-transition sidebar-mini"
      >
      
           <% 
     Boolean Ino = null;
     try {
         Ino = (Boolean) session.getAttribute("loggedIn");
     } catch (Exception e) {
         // Handle the exception, such as printing the stack trace
     }
     if (Ino == null || !Ino) {
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
    
    <%@ page import="entities.Employee" %>
    <section class="hold-transition sidebar-mini">
    <div class="wrapper">
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <div class="container-fluid">
                    <div class="row mb-2">
                        <div class="col-sm-6">
                            <h1>DataTables</h1>
                        </div>
                        <div class="col-sm-6">
                            <ol class="breadcrumb float-sm-right">
                                <li class="breadcrumb-item"><a href="#">Home</a></li>
                                <li class="breadcrumb-item active">DataTables</li>
                            </ol>
                        </div>
                    </div>
                </div><!-- /.container-fluid -->
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">DataTable with default features</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                          <thead>
                <tr>
                    
                    <th>Code</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Date of Birth</th>
                    <th>Phone Number</th>
                    <th>Address</th>
                    
                    <th>Marital Status</th>
                    
                    <th>EsiNumber</th>
                    <th>Position</th>
                    <th>Account Number</th>
                    <th>Net Salary</th>
                    <th>PaymentMode</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <% /*  EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
                List<Employee> allEmployees = employeeDAO.getAllEmployees(); */
                List<Employee> allEmployees = (List<Employee>) request.getAttribute("employees");
                                            for (Employee employee : allEmployees) {
                                        %>
                                        <tr onclick="redirectToProfile('<%=employee.getEmployeeID()%>')">
										    <td><%= employee.getCode() %></td>
										    <td><%= employee.getFirstName() %></td>
										    <td><%= employee.getLastName() %></td>
										    <td><%= employee.getDateOfBirth() %></td>
										    <td><%= employee.getPhoneNumber() %></td>
										    <td><%= employee.getAddress() %></td>
										    <td><%= employee.getMaritalStatus() %></td>
										    <td><%= employee.getEsiNumber()%></td> <!-- Add Employee State Insurance (No. ESI) attribute -->
										    <td><%= employee.getPosition() %></td> <!-- Add Position attribute -->
										    <td><%= employee.getAccountNumber() %></td> <!-- Add Account Number attribute -->
										    <td><%= employee.getSalnet() %></td> <!-- Add Net Salary attribute -->
										    <td><%= employee.getPaymentMode() %></td> <!-- Add Payment Mode attribute -->
										</tr>

                                        <% } %>
            </tbody>
                                      <!--  <tfoot>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                             Add more columns as needed 
                                        </tr>
                                        </tfoot>-->
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                        <!-- /.col -->
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </section>
            <!-- /.content -->
        </div>
    </div>
    </section>
</div>
<!-- ./wrapper -->

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
<script src="plugins/pdfmake/pdfmake.min.js"></script>
<script src="plugins/pdfmake/vfs_fonts.js"></script>
<script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
<script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

<script>
    $(function () {
        $("#example1").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
        }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
        $('#example2').DataTable({
            "paging": true,
            "lengthChange": false,
            "searching": false,
            "ordering": true,
            "info": true,
            "autoWidth": false,
            "responsive": true,
        });
    });

</script>
<%@ include file="footer.jsp"%></body>
</html>

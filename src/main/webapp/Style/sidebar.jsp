  <!-- Main Sidebar Container -->
  <%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="LG.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">HR Nexus</span>
    </a>
 <%
        // Retrieve session object
        //HttpSession session = request.getSession();
        
        // Retrieve session attributes
        String username = (String) session.getAttribute("fullname");
        String photo = (String) session.getAttribute("photo");
        String idcur ="";
        try {
        	 idcur = (String) session.getAttribute("idEmp");
        } catch (Exception e) {
        	// TODO: handle exception
        }
            
       
        Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
        
        // Display session data
        if(username != null && loggedIn != null && loggedIn) {}
    %>
    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<%= photo%>" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="./Profile?q=<%=idcur%>" class="d-block"><%= username%></a>
        </div>
      </div>

      <!-- SidebarSearch Form -->
      <div class="form-inline">
        <div class="input-group" data-widget="sidebar-search">
          <input class="form-control form-control-sidebar" type="search" placeholder="Search" aria-label="Search">
          <div class="input-group-append">
            <button class="btn btn-sidebar">
              <i class="fas fa-search fa-fw"></i>
            </button>
          </div>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item menu-open">
            <a href="./dashboard.jsp" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Dashboard
                <i class="right fas "></i>
              </p>
            </a>
            
          </li>
          <li class="nav-item">
            <a href="pages/widgets.html" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Widgets
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Layout Options
                <i class="fas  right"></i>
                <span class="badge badge-info right">6</span>
              </p>
            </a>
            
          </li>
          
          
          <li class="nav-item">
            <a href="./addEmp.jsp" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Add an Employee
                <i class="fas  right"></i>
              </p>
            </a>
            
          </li>
          <li class="nav-item">
            <a href="./EmployeeServlet" class="nav-link">
              <i class="nav-icon fas fa-table"></i>
              <p>
                Employees
                <i class="fas  right"></i>
              </p>
            </a>
           
          </li>
         <!--<li class="nav-header">EXAMPLES</li>--> 
          <li class="nav-item">
            <a href="pages/calendar.html" class="nav-link">
              <i class="nav-icon fas fa-calendar-alt"></i>
              <p>
                Calendar
                <span class="badge badge-info right">2</span>
              </p>
            </a>
          </li>
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-envelope"></i>
              <p>
                Mailbox
                <i class="fas  right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="pages/mailbox/mailbox.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Inbox</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="pages/mailbox/compose.html" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Compose</p>
                </a>
              </li>
              
            </ul>
          </li>
          
          
          
          
          
          <li class="nav-item">
            <a href="../Style/payslips.jsp" class="nav-link">
              <i class="nav-icon fas fa-file"></i>
              <p>Payslips</p>
            </a>
          
          
          
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
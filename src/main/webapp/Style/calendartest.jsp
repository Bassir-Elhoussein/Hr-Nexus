<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <%@ page import="manage.dao.*"%>
        <%@ page import="entities.*"%>
        <%@ page import="entities.User" %>
        <%@page import="java.util.List" %>
        <%@page import="java.util.Date" %>
        <%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>


        
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Calendar</title>
  <link rel="icon" type="image/png" href="LG.png" />
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
  <!-- fullCalendar -->
  <link rel="stylesheet" href="plugins/fullcalendar/main.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/adminlte.min.css">

</head>
<body class="hold-transition sidebar-mini">
        <%@ page import="manage.dao.*"%>
        <%@ page import="entities.*"%>
        <%@ page import="entities.User" %>
        <%@page import="java.util.List" %>
        <%@page import="java.util.Date" %>
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
        <div class="content-wrapper">
          <!-- Content Header (Page header) -->
          <section class="content-header">
            <div class="container-fluid">
              <div class="row mb-2">
                <div class="col-sm-6">
                  <h1>Calendar</h1>
                </div>
                <div class="col-sm-6">
                  <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="#">Home</a></li>
                    <li class="breadcrumb-item active">Calendar</li>
                  </ol>
                </div>
              </div>
            </div><!-- /.container-fluid -->
          </section>
      
          <!-- Main content -->
          <section class="content">
            <div class="container-fluid">
              <div class="row">
                <div class="col-md-3">
                  <div class="sticky-top mb-3">
                    <div class="card">
                      <div class="card-header">
                        <h4 class="card-title">Draggable Events</h4>
                      </div>
                      <div class="card-body">
                        <!-- the events -->
                        <div id="external-events">



                          
                          <div class="external-event bg-success">Client Meeting</div>
                          <div class="external-event bg-warning">Family Emergency</div>
                          <div class="external-event bg-info">Time off</div>
                          <div class="external-event bg-primary">Rest and Recovery</div>
                          <div class="external-event bg-danger">Absent</div>
                          <div class="checkbox">
                            <label for="drop-remove">
                              <input type="checkbox" id="drop-remove">
                              remove after drop
                            </label>
                          </div>
                        </div>
                      </div>
                      <!-- /.card-body -->
                    </div>
                    <!-- /.card -->
                    <div class="card">
                      <button id="submit-form" class="btn btn-primary">Save Events</button>
                      
                    </div>
                  </div>
                </div>
                <!-- /.col -->
                <div class="col-md-9">
                  <div class="card card-primary">
                    <div class="card-body p-0">
                      <!-- THE CALENDAR -->
                      <div id="calendar"></div>
                    </div>
                    <!-- /.card-body -->
                  </div>
                  <!-- /.card -->
                </div>
                <!-- /.col -->
              </div>
              <!-- /.row -->
            </div><!-- /.container-fluid -->
          </section>
          <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
      </div>
      <%
    //List<Events> eventList = (List<Events>) request.getAttribute("eventList"); // Assuming your list is stored in a request attribute
      
         String queryParameter = request.getParameter("c");
		//String queryParameter = request.getParameter("idc");
		EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();
        UserDAOImpl udao = new UserDAOImpl();
        int employeeID =Integer.parseInt(queryParameter);
        // Call the deleteEmployee method
		        Employee em=employeeDAO.getEmployeeById(employeeID);
		// Create a new list to store events
		List<Events> eventList = new ArrayList<>();
		
		// Add some events to the list
		eventList=em.getEvents() ;
		
		
		// Set the eventList as a request attribute for further processing


%>
       <script>
        function redirecttocalendar(employeeID) {
          // Redirect to the employee profile page with the employee ID
          window.location.href = "../EventServlet?idce="+employeeID;
        }
      </script>
     
                                                    
      <form id="calendarForm" method="POST" action="./EventServlet?idce=<%=employeeID%>"> <!-- Changed action to your servlet URL -->
        <input id="events-data" type="hidden" name="events-data"> <!-- Hidden input field to store serialized events -->
        
      </form>
      
<!-- ./wrapper -->

<!-- jQuery -->
<script src="plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- jQuery UI -->
<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- fullCalendar 2.2.5 -->
<script src="plugins/moment/moment.min.js"></script>
<script src="plugins/fullcalendar/main.js"></script>
<!-- AdminLTE for demo purposes -->

<script>
  $(function () {
      /* initialize the external events */
      function ini_events(ele) {
          ele.each(function () {
              var eventObject = {
                  title: $.trim($(this).text())
              }
              $(this).data('eventObject', eventObject)
              $(this).draggable({
                  zIndex: 1070,
                  revert: true,
                  revertDuration: 0
              })
          })
      }

      ini_events($('#external-events div.external-event'))

      /* initialize the calendar */
      var date = new Date()
      var d = date.getDate(),
          m = date.getMonth(),
          y = date.getFullYear()

      var Calendar = FullCalendar.Calendar;
      var Draggable = FullCalendar.Draggable;

      var containerEl = document.getElementById('external-events');
      var checkbox = document.getElementById('drop-remove');
      var calendarEl = document.getElementById('calendar');

      new Draggable(containerEl, {
          itemSelector: '.external-event',
          eventData: function (eventEl) {
              return {
                  title: eventEl.innerText,
                  backgroundColor: window.getComputedStyle(eventEl, null).getPropertyValue('background-color'),
                  borderColor: window.getComputedStyle(eventEl, null).getPropertyValue('background-color'),
                  textColor: window.getComputedStyle(eventEl, null).getPropertyValue('color'),
              };
          }
      });

      var calendar = new Calendar(calendarEl, {
          headerToolbar: {
              left: 'prev,next today',
              center: 'title',
              right: 'dayGridMonth,timeGridWeek,timeGridDay'
          },
          themeSystem: 'bootstrap',
          events: [
              // Your default events here
          ],
          editable: true,
          droppable: true,
          drop: function (info) {
              if (checkbox.checked) {
                  info.draggedEl.parentNode.removeChild(info.draggedEl);
              }
          }
      });

      calendar.render();

      $('#color-chooser > ul > li > a').click(function (e) {
          e.preventDefault()
          currColor = $(this).css('color')
          $('#add-new-event').css({
              'background-color': currColor,
              'border-color': currColor
          })
      })

      $('#add-new-event').click(function (e) {
          e.preventDefault()
          var val = $('#new-event').val()
          if (val.length == 0) {
              return
          }
          calendar.addEvent({
              title: val,
              start: new Date(y, m, d), // Default start date
              allDay: true // Default all day event
          });
          $('#new-event').val('');
      });
      
      // Parse JSON data and add events to the calendar
      

     
    
  
    // Construct JSON data for events
var eventData = [
  <% for (int i = 0; i < eventList.size(); i++) { %>
    {
      "title": "<%= eventList.get(i).getTitle() %>",
      "start": "<%= eventList.get(i).getYear() %>-<%= eventList.get(i).getMonth() %>-<%= eventList.get(i).getDay() %>",
      "end": ""
    }<%= i < eventList.size()  ? "," : "" %>
  <% } %>
];

      // Assuming 'jsonData' is a variable containing JSON data
      if (eventData) {
          calendar.addEventSource(eventData);
      }

      // Submitting the form
      $('#submit-form').click(function () {
          var events = calendar.getEvents().map(event => {
              return {
                  title: event.title,
                  start: event.start.toISOString(),
                  end: event.end ? event.end.toISOString() : null
              };
          });
          $('#events-data').val(JSON.stringify(events));
          $('#calendarForm').submit();
      });
  })
</script>

  <%@ include file="footer.jsp"%>
</body>
</html>

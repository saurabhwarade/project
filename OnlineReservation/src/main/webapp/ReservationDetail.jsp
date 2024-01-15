<%@ page import="org.hibernate.Session" %>
<%@ page import="Util.HibernateUtil" %>
<%@ page import="org.hibernate.Transaction" %>


<%@ page import="java.util.List" %>
<%@ page import="Dao.UserDao" %>
<%@ page import="Model.Reservation" %><%--
  Created by IntelliJ IDEA.
  User: saura
  Date: 24-12-2023
  Time: 02:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL</title>
    <%@include file="Links.jsp" %>
    <%--<%@include file="nav.jsp" %>--%>
</head>
<body>


<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Reservation Detail</p>

                                <%
                                    String msg = (String) session.getAttribute("msg");
                                    if (msg != null) {
                                %>
                                <p class="text-success text-center"><%=msg%>
                                </p><%
                                    session.removeAttribute("msg");
                                }
                            %>
                                <form action="cancelReservation" class="mx-1 mx-md-4" method="get">


                                    <div class="row justify-content-center">
                                        <table class="table table-striped ">



                                                    <thead>
                                                    <tr>


                                                        <th scope="col">From</th>
                                                        <th scope="col">To</th>
                                                        <th scope="col">Train Name/Number</th>
                                                        <th scope="col">Seat Number</th>
                                                        <th scope="col">Class Type</th>
                                                        <th scope="col">Date of Journey</th>

                                                    </tr>
                                                    </thead>

                                            <tbody>
                                                <%
                                                //              User userData = (User) session.getAttribute("userData");

                                                UserDao userDao = new UserDao();

                                                List<Reservation> reservationList = userDao.getReservation();

                                                for (Reservation reservation : reservationList) {

                                            %>


                                            <tr>



                                                <td><%=reservation.getReservationFrom()%>
                                                <td><%=reservation.getReservationTo()%>
                                                <td><%=reservation.getTrainName()%>
                                                <td><%=reservation.getSeatNum()%>
                                                <td><%=reservation.getClassType()%>
                                                <td><%=reservation.getDateOfJourney()%>


                                                <td class="d-flex">
                                                    <a onclick="alert('Are you sure canceled reservation')"
                                                       href="delete?delete=<%=reservation.getPnr()%>"
                                                       class="btn btn-sm me-1 btn-danger">

                                                        Cancel</a>
                                                    <%--  <div &lt;%&ndash;class="d-flex justify-content-center mx-4 mb-3 mb-lg-4"&ndash;%&gt;>
                                                          <button type="submit"class="btn btn-sm me-1 btn-danger"<%=reservation.getPnr()%>>Cancel</button>--%>
                                    </div>

                                    </td>
                                    </tr>

                                    <%

                                        }

                                    %>

                                    </tbody>
                                    </table>

                                </form>

                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>

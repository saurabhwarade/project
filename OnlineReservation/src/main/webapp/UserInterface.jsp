<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reservation</title>
    <%@include file="Links.jsp" %>
</head>
<body>
  <%@include file="nav.jsp" %>
<%--<%@include file=""%>--%>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h3 mb-5 mx-1 mx-md-4 mt-4">
                                    welcome  <%=session.getAttribute("userName")%>
                                </p>
                                <p class="text-center h1 mb-5 mx-1 mx-md-4 mt-4">
                                </p>
                                <%
                                    String msg = (String) session.getAttribute("msg");
                                    if (msg != null) {
                                %> <p class="text-success text-center"><%=msg%>
                            </p><%
                                    session.removeAttribute("msg");
                                }
                            %>

                                <p class="text-primary text-center"><label>PNR Number
                                    :</label> <%=session.getAttribute("userData")%>
                                </p>
                                <form action="reservation" class="mx-1 mx-md-4" method="post">

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label class="form-label" for="from">From</label>
                                            <select class="form-control" name="from" id="from">
                                                <option value="Pune JN">Pune JN</option>
                                                <option value="Mumbai">Mumbai</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-user fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">

                                            <label class="form-label" for="to">To</label>
                                            <select class="form-control" name="to" id="to">
                                                <option value="Mumbai">Mumbai</option>
                                                <option value="Nagpur">Nagpur</option>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">

                                            <label class="form-label" for="tName">Train Name/Number</label>
                                            <select class="form-control" name="tName" id="tName">
                                                <option value="CSMT VANDEBHARAT (22226)">CSMT VANDEBHARAT (22226)</option>
                                                <option value="PUNE BHUJ EXP (11092)">PUNE BHUJ EXP (11092)</option>

                                            </select>
                                        </div>
                                    </div>

                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label for="cType">Class type</label>
                                            <select class="form-control" name="cType" id="cType">
                                                <option value="firstClass">First Class</option>
                                                <option value="secondClass">Second Class</option>
                                                <option value="sleeperClass">Sleeper Class</option>
                                                <option value="economyClass">Economy Class</option>
                                                <option value="businessClass">Business Class</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <label for="seatNumber">Select seat</label>
                                            <select class="form-control" name="seatNumber" id="seatNumber">
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>

                                            </select>
                                        </div>
                                    </div>
                                    <div class="d-flex flex-row align-items-center mb-4">
                                        <i class="fas fa-lock fa-lg me-3 fa-fw"></i>
                                        <div class="form-outline flex-fill mb-0">
                                            <input type="date" name="dJourney" id="dJourney" class="form-control"/>
                                            <label class="form-label" for="dJourney">Date of Journey</label>
                                        </div>
                                    </div>


                                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                                        <button type="submit" class="btn btn-primary btn-lg">Book Your Seat</button>
                                    </div>

                                </form>

                            </div>
                            <%--              <div class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">--%>

                            <%--                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"--%>
                            <%--                     class="img-fluid" alt="Sample image">--%>

                            <%--              </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


</body>
</html>
</title>
</head>
<body>

</body>
</html>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seat</title>
    <%@include file="Links.jsp" %>
    <style>
        /* Add your custom styles here */
        .seat {
            width: 50px;
            height: 50px;
            margin: 5px;
            background-color: #ddd;
            cursor: pointer;
        }

        .selected {
            background-color: #007bff;
            color: #fff;
        }
    </style>
</head>
<body>
<%--<%@include file="nav.jsp"%>--%>
<section class="vh-100" style="background-color: #eee;">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <div class="card text-black" style="border-radius: 25px;">
                    <div class="card-body p-md-5">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

                                <p class="text-center h1  mb-5 mx-1 mx-md-4 mt-4">Select your seat</p>

                                <form action="seatBook" name="seat" class="mx-1 mx-md-4" method="post">


                                    <div class="container mt-5">

                                        <div id="seatMap"  class="d-flex flex-wrap"></div>
                                        <p class="mt-3">Selected Seat: <span id="selectedSeat"></span></p>
                                    </div>


                                    <script>
                                        $(document).ready(function () {
                                            const seatMap = $('#seatMap');
                                            const selectedSeatElement = $('#selectedSeat');
                                            const totalSeats = 30;

                                            for (let i = 1; i <= totalSeats; i++) {
                                                const seat = $('<div>', { class: 'seat', text: i });
                                                seat.click(function () {
                                                    $(this).toggleClass('selected');
                                                    updateSelectedSeats();
                                                });
                                                seatMap.append(seat);
                                            }

                                            function updateSelectedSeats() {
                                                const selectedSeats = $('.seat.selected');
                                                const selectedSeatNumbers = selectedSeats.map(function () {
                                                    return $(this).text();
                                                }).get();
                                                selectedSeatElement.text(selectedSeatNumbers.join(', '));
                                            }
                                        });
                                    </script>
                                    <button type="submit" name="seat">Book Now</button>

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
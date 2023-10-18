<%-- 
    Document   : footer
    Created on : May 30, 2022, 8:50:43 PM
    Author     : son22
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="footer">

    <!-- Feedback Form -->
    <div class="modal fade col-md-12" role="dialog" id="feedback_common">
        <div class="modal-dialog">
            <div class="modal-content" style="border-radius: 10px; margin-top: 60px;">
                <div class="modal-header">
                    <h2 style="margin-left: 35%">Comments</h2>
                </div>
                <div class="modal-body">
                    <form action="feedback_common">
                        <b>Write Comment:</b>&nbsp;&nbsp;
                        <div class="form-group">
                            <textarea name="subject" placeholder="Viết bình luận.." style="height:200px ; width: 460px"></textarea>
                        </div>
                        <b>Image's Respond:</b>&nbsp;&nbsp;
                        <div class="form-group">
                            <input name="imageurl" type="file" class="form-control" style="border-radius: 100px;" required="">
                        </div>
                        <b>Rate:</b>&nbsp;&nbsp;
                        <div class="form-group" >
                            <select name = "star" style="border-radius: 100px;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                                <option selected>Rating For VDreamer</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select>
                        </div>
                        <br>
                        <center><button type="submit" class="btn btn-dark" style="padding-right: 160px;padding-left: 160px; border-radius: 100px;">Comments</button></center>
                    </form>
                    <br><br>
                </div>
            </div>
        </div>
    </div>
    
    <div class="map">
        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3929.735018289041!2d105.75462091477622!3d10.037731875761857!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175e7e4a5f0f7d7%3A0x5c3f3a27e5a8d11a!2sFPT%20University%20Can%20Tho!5e0!3m2!1sen!2s!4v1653919437201!5m2!1sen!2s" 
                width=90% height="400" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
    </div>

    <div class="info-footer">
        <div class="content-footer">
            <h2>Address</h2>
            <p class="mt-40">VDreamer Can Tho: Hung Loi, Ninh Kieu, Can Tho City</p>
        </div>

        <div class="feedback-footer">
            <h2 class="mt-40">VDreamer</h2>
            <p>We always appreciate and listen to all feedback from customers to be able to upgrade the service and product experience better every day. <br>Please leave your comments below!!!</p>
            <a data-toggle="modal" data-dismiss="modal" data-target="#feedback_common"><input class="Button-Feedback mt-16" type="submit" value="Comments"></a> 
            <br>
            <br>
            <br>
            <div class="contact-info">
                <p><i class="ti-location-pin"></i>Can Tho,Hau Giang </p>
                <p><i class="ti-mobile"></i>Phone: 0969091310</p>
                <p style="white-space: nowrap;"><i class="ti-email"></i>hungloipro123@gmail.com</p>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="clear"></div>


</div>

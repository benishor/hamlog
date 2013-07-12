<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page pageEncoding="utf-8" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Add QSO</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Adrian Scripca">

    <link href="${contextPath}/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

    </style>
    <link href="${contextPath}/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="${contextPath}/assets/bootstrap/css/datetimepicker.css" rel="stylesheet">

    <script src="${contextPath}/assets/jquery/jquery-1.9.1.min.js"></script>
    <script src="${contextPath}/assets/bootstrap/js/bootstrap.js"></script>
    <script src="${contextPath}/assets/bootstrap/js/bootstrap-datetimepicker.js"></script>
    <script language="JavaScript">
        $(function () {
            $('.form_datetime').datetimepicker({
                format: 'yyyy-mm-dd hh:ii',
                linkFormat: 'dd MM yyyy hh:ii',
                autoclose: true
            });
            $('#qso-datetime-start').datetimepicker('setDate', new Date(${addQsoForm.startDate.time}));
        });
    </script>
</head>

<body>
    <div class="container">

        <form:form method="post" action="${requestScope['javax.servlet.forward.request_uri']}" id="addQsoForm" commandName="addQsoForm">
            <div class="row-fluid">

                <div class="span6">

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('callsign') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-callsign">Callsign</label>
                        <form:input id="qso-callsign" path="callsign" placeholder="callsign"/>
                        <div class="help-inline"><form:errors path="callsign"/></div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('band') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-band">Band</label>

                        <div class="controls">
                            <form:select id="qso-band" path="band" items="${bandList}"/>
                            <div class="help-inline"><form:errors path="band"/></div>
                        </div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('myMode') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-mode-mine">My Mode</label>

                        <div class="controls">
                            <form:select id="qso-mode-mine" path="myMode" items="${modeList}"/>
                            <div class="help-inline"><form:errors path="myMode"/></div>
                        </div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('hisMode') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-mode-his">His Mode</label>

                        <div class="controls">
                            <form:select id="qso-mode-his" path="hisMode" items="${modeList}"/>
                            <div class="help-inline"><form:errors path="hisMode"/></div>
                        </div>
                    </div>


                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('startDate') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-date-start-mirror">Start date</label>

                        <div class="controls">

                            <div id="qso-datetime-start" class="input-append date form_datetime qso-datetime-start" data-link-field="qso-date-start-mirror" data-link-format="dd MM yyyy hh:ii">
                                <form:input type="hidden" value="" path="startDate" id="qso-date-start" name="startDate"/>
                                <input type="text" id="qso-date-start-mirror" value="" readonly/>
                                <span class="add-on"><i class="icon-th"></i></span>

                                <div class="help-inline"><form:errors path="startDate"/></div>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="span6">


                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('rstSent') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-rst-sent">RST sent</label>

                        <div class="controls">
                            <form:input path="rstSent" id="qso-rst-sent" name="qso-rst-sent" type="text" placeholder="how I heard him"/>
                            <div class="help-inline"><form:errors path="rstSent"/></div>
                        </div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('rstReceived') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-rst-rcvd">RST received</label>

                        <div class="controls">
                            <form:input path="rstReceived" id="qso-rst-rcvd" name="qso-rst-rcvd" type="text" placeholder="how he heard me"/>
                            <div class="help-inline"><form:errors path="rstReceived"/></div>
                        </div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('operator') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group ${errorClass}">
                        <label class="control-label" for="qso-operator">Operator</label>

                        <div class="controls">
                            <form:input path="operator" id="qso-operator" name="qso-operator" type="text" placeholder="operator name"/>
                            <div class="help-inline"><form:errors path="operator"/></div>
                        </div>
                    </div>

                    <spring:hasBindErrors name="addQsoForm">
                        <c:set var="errorClass" value="${errors.hasFieldErrors('qth') ? 'error' : ''}"/>
                    </spring:hasBindErrors>
                    <div class="control-group">
                        <label class="control-label" for="qso-qth">Qth</label>

                        <div class="controls">
                            <form:input path="qth" id="qso-qth" name="qso-qth" type="text" placeholder="operator location"/>
                            <div class="help-inline"><form:errors path="qth"/></div>
                        </div>
                    </div>

                </div>
            </div>
            <div class="row-fluid">
                <div class="span4">&nbsp;</div>
                <div class="span4 text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <button class="btn">Cancel</button>
                </div>
                <div class="span4">&nbsp;</div>
            </div>
        </form:form>

    </div>

</body>
</html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <spring:url value="/resources/css/project.css" var="projectCss" />

    <link href="${projectCss}" rel="stylesheet" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Home Page</title>
</head>
<body>
    <div>
        <table>
            <tr>
                <th>Name</th>
                <th>Last Name</th>
                <th>Skill</th>
                <th>Level</th>
                <th>Age</th>
            </tr>
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>${person.name}</td>
                    <td>${person.lastName}</td>
                    <td>${person.skill}</td>
                    <td>${person.level}</td>
                    <td>${person.age}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>

</html>
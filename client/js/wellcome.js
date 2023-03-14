window.onload = function () {
    var myHeaders = new Headers();
    myHeaders.append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2kxMjM0NSIsImlhdCI6MTY3ODY3NzI2NiwiZXhwIjoxNjc4NzEzMjY2fQ.nplwD0mSHvLt2zUWzSVj2lCtu4WVxpu7iYQj4b_kcqA");

    var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch("http://147.182.242.164:8080/stockmaster/wellcome", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
};


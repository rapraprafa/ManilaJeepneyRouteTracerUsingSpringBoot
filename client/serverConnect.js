function getAllRouteNames(){
    var routesComboBox = document.getElementById("routes");
    var comboBoxValues = [];
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
         if (this.readyState == 4 && this.status == 200) {
             var routeArray = JSON.parse(this.responseText);
             for(let i = 0; i < routeArray.length; i++){
                comboBoxValues.push(routeArray[i].routename);
             }
             for(let j = 0; j < routeArray.length; j++){
                var option = document.createElement("option")
                option.value = comboBoxValues[j];
                option.textContent = comboBoxValues[j];;
                routesComboBox.appendChild(option)
             }
         }
    };
    xhttp.open("GET", "http://localhost:8080/api/routes", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send('');
}
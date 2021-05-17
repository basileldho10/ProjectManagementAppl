
var chartDataString = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataString);
var arraylength = chartJsonArray.length;
var numericData = [];
var LabelData = [];

for(var i=0; i < arraylength; i++){
	numericData[i] =  chartJsonArray[i].value;
	LabelData[i] = chartJsonArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
        labels: LabelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            data: numericData
        }]

},
	
	options: {
		title: {
			display: true,
			text: 'project Statuses'
		}
			
	}
}); 


// ""[{"ProjectStage": "Completed", "Count": x}, {"ProjectStage": "In Progress", "Count": x}
//      ,{"ProjectStage": "Not Started", "Count": x}]"

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}



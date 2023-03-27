#!/usr/bin/env groovy
def call(String name = 'human') {
  echo "Hello, ${name}."
    echo 'Hello World'
                def my_list = ["abc.dat@yamil.com", "abc1.dat@yamil.com", "abc2.dat@yamil.com", "abc3.dat@yamil.com"]
                env.my_string = my_list.join(",")
                println my_string
                sh """
                echo "my string is : ${my_string}"
                cat <<EOF >> 1.json
                  {
	
	"scanresults": [
	
	{
		"jsonresult":{
			"failure":2,
			"status": "Fail",
			"vul":[
			
				{
					"display":"as: ka : sa",
					"jkj":{
						"sa":"jd"
						}
				},
								{
					"display":"as: ka1 : sa",
					"jkj":{
						"sa":"jd"
						}
				}
			]
		}
	}
	]
}
EOF
ls -ltr
                
                """
                sh '''
               #!/bin/bash
# Set the output file name
output_file="output1.html"
# Start the HTML file with basic structure
echo "<!DOCTYPE html>" > $output_file
echo "<html>" >> $output_file
echo "<head>" >> $output_file
echo "<title>JSON to HTML Example</title>" >> $output_file
echo "<style>" >> $output_file
echo "table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding-top: 10px;
  padding-bottom: 20px;
  padding-left: 30px;
  padding-right: 40px;
}" >> $output_file
echo "</style>" >> $output_file
echo "</head>" >> $output_file
echo "<body>" >> $output_file
echo "<table>" >> $output_file
echo "<th>Application name</th>" >> $output_file
echo "<th>failure</th>" >> $output_file
echo "<th>status</th>" >> $output_file
echo "<th>Display Name</th>" >> $output_file
# Loop through each JSON file
for file in *.json
do
  
  # Extract the data from the JSON file using jq
  data=$(jq '.scanresults[0].jsonresult.vul' $file)
  length=$(echo $data | jq '. | length')
  echo "length is : $length"
  
  echo	"<tr><th rowspan="$((length+1))">$(basename $file .json)</th>"  >> $output_file
  echo "<th rowspan="$((length+1))">$(jq '.scanresults[0].jsonresult.failure' $file)</th>"  >> $output_file
   echo "<th rowspan="$((length+1))">$(jq '.scanresults[0].jsonresult.status' $file)</th></tr>"  >> $output_file
   
  # Add the data to the HTML file as a table
   echo "$data" | jq -c '.[]' | while read i; do
	
  
    echo "<tr><td>$(echo "$i" | jq -r '.display')</td></tr>" >> $output_file
	
done
  
  
done
# Close the HTML file
echo "</body>" >> $output_file
echo "</html>" >> $output_file
                '''
            publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: false,
            reportDir: '.',
            reportFiles: 'output1.html',
            reportName: 'Report'
          ]
}

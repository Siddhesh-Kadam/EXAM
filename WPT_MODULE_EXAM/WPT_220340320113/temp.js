
const express = require('express');
const app = express();
const cors = require('cors');
app.use(cors());
const bodyParser = require('body-parser');

app.use(express.static('abc'));
app.use(bodyParser.json()); // support json encoded bodies
app.use(bodyParser.urlencoded({ extended: true }));
//whether you want nested objects support  or not

const mysql = require('mysql2');

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '$1d@root',
    database: 'WPT',
	port:3306
});

// Adding a book
app.get('/addbook', (req, res) => {
	
	let bookid = req.query.bookid;
	let bookname = req.query.bookname;
	let price = req.query.price;

	let output = {status:false};

	connection.query('insert into book values (?, ? ,?)', [bookid, bookname, price], (err, result) => {

		if (err) {
			console.log(err);
		} else {
			if (result.affectedRows > 0) {
				output.status = true;
				console.log(result);
			} else {
				console.log(result);
			}
		}
		res.send(output);
	});
});

// Listing all books
app.get('/showall', function (req, res) {    
		
	let output = {status:false, books:[]};

	connection.query('select * from book', (err, result) => {

		if (err) {
			console.log(err);
		} else {
			if (result.length > 0) {
				output.status = true;
				for (let i = 0; i < result.length; i++) {
					output.books.push(result[i]);
				}
				console.log(output);
			} else {
				console.log(result);
			}
		}
		res.send(output);
	});
});


app.listen(8081, function () {
    console.log("server listening at port 8081...");
});

// My CODE IS WORKINGG!!!
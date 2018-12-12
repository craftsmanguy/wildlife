// Get dependencies
const express = require('express');
const path = require('path');
const http = require('http');
const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');

// Get our API routes
const adverts = require('./server/routes/adverts');
const admins = require('./server/routes/admins');
const users = require('./server/routes/users');
const pets = require('./server/routes/pets');

const app = express();

// Parsers for POST data
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

// Point static path to dist
app.use(express.static(path.join(__dirname, 'dist')));


//Use cookies
app.use(cookieParser());


// Set our api routes
app.use('/api', admins);
app.use('/api', adverts);
app.use('/api', users);
app.use('/api', pets);


// Catch all other routes and return the index file
app.get('*', (req, res) => {
  res.sendFile(path.join(__dirname, 'dist/index.html'));
});

/**
 * Get port from environment and store in Express.
 */
const port = process.env.PORT || '8082';
const hostname = process.env.hostname || '0.0.0.0';
app.set('port', port);
app.set('hostname', hostname);


/**
 * Create HTTP server.
 */
const server = http.createServer(app);

/**
 * Listen on provided port, on all network interfaces.
 */
server.listen(port, hostname, () => console.log(`API running on ${hostname}:${port}`));
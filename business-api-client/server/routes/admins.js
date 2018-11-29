const express = require('express');
const router = express.Router();
var qs = require('querystring');


// declare axios for making http requests
const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';


//*****************
//LOGIN
//*****************
router.post('/v1/authenticate', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/authentication/login`,
    data: req.body
  }).then(function (response) {

    res.cookie(
      'access_token', response.headers.authorization, {
        expire: new Date(Date.now() + 900000),
        secure: true,
        httpOnly: true,
        path: '/page',
      });
    res.status(response.status).json();
  }).catch(function (error) {
    errorHandler(error, res);
  });
});

function errorHandler(error, res) {
  if (error.response) {
    return res.status(error.response.status).send(error.response.headers.reason);
  } else if (error.request) {
    res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
  } else {
    res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
  }
};



/* GET cooking */
router.get('/', (req, res) => {
  res.send('api works');
  console.log('Cookies: ', req.cookies)
});

//
router.get('/cookie', function (req, res) {
  res.cookie(cookie_name, 'cookie_value').send('Cookie is set');
});


module.exports = router;
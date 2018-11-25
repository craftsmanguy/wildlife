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
    if (error.response) {
      res.status(error.response.status).json(error.response.data.description)
        ;
    } else if (error.request) {
      console.log('requete erreur : ' + error);
      res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
    } else {
      // Something happened in setting up the request that triggered an Error
      console.log('requete erreur : ' + error);
      res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
    }
  });
});


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
const express = require('express');
const router = express.Router();

// declare axios for making http requests
const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';
const USER_RESOURCE = 'users';


router.get('/users/current', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/current`,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.data);
    })
    .catch(function(error) {

      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        console.log('requete : ' + error);
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


router.get('/users/:id', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${USER_RESOURCE}/`  + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.headers.authorization,
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.data);
    })
    .catch(function(error) {

      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
      } else if (error.request) {
        console.log('requete erreur : ' + error);
        res.status(503).send('The server is currently unable to handle the request due to a temporary overloading or maintenance of the server.');
      } else {
        console.log('requete : ' + error);
        // Something happened in setting up the request that triggered an Error
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});

/*
 * Register user
 */
router.post('/users', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/${USER_RESOURCE}`,
    data: {
      pseudonym: req.body.pseudonym,
      email: req.body.email,
      country: req.body.country,
      postalCode: req.body.postalCode,
      city: req.body.city,
      password: req.body.password,
      confirmPassword: req.body.confirmPassword
    },
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(function(response) {
      res.status(response.status).json(response.headers);
    })
    .catch(function(error) {
      if (error.response) {
        res.status(error.response.status).json(error.response.data.description);
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


module.exports = router;

const express = require('express');
const router = express.Router();

// declare axios for making http requests
const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';
const USER_RESOURCE = 'users';


router.get('/v1/users/current', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${USER_RESOURCE}/current`,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {

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


router.get('/v1/users/:id', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${USER_RESOURCE}/` + req.params.id,
    responseType: 'json',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.data);
    })
    .catch(function (error) {

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
router.post('/v1/users', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/${USER_RESOURCE}`,
    data: req.body,
    headers: {
      'Content-Type': 'application/json',
      'Authorization': req.cookies['access_token'],
    }
  })
    .then(function (response) {
      res.status(response.status).json(response.headers);
    })
    .catch(function (error) {
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

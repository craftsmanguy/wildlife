const express = require('express');
const router = express.Router();

// declare axios for making http requests
const axios = require('axios');
const HOST = 'http://wildlives-int.ovh:8081';
const CONTEXT = 'business';
const VERSION = 'v1';
const PET_RESOURCE = 'pets';
const RACE_RESOURCE = 'races';


router.get('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
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


router.get('/v1/pets', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}`,
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

router.delete('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'delete',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
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


router.post('/v1/pets', (req, res, next) => {
  axios({
    method: 'post',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}`,
    data: {
      wlAniName: req.body.wlAniName,
      wlAniLof: req.body.wlAniLof,
      wlAniYear: req.body.wlAniYear,
      wlAniSexe: req.body.wlAniSexe,
      wlAniDescrip: req.body.wlAniDescrip,
      specieId: req.body.specieId,
    },
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
        // Something happened in setting up the request that triggered an Error
        console.log('requete erreur : ' + error);
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


router.put('/v1/pets/:id', (req, res, next) => {
  axios({
    method: 'put',
    url: `${HOST}/${CONTEXT}/${VERSION}/${PET_RESOURCE}/` + req.params.id,
    data: {
      wlAniName: req.body.wlAniName,
      wlAniLof: req.body.wlAniLof,
      wlAniYear: req.body.wlAniYear,
      wlAniSexe: req.body.wlAniSexe,
      wlAniDescrip: req.body.wlAniDescrip,
      specieId: req.body.specieId,
    },
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
        // Something happened in setting up the request that triggered an Error
        console.log('requete erreur : ' + error);
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


router.get('/v1/races', (req, res, next) => {
  axios({
    method: 'get',
    url: `${HOST}/${CONTEXT}/${VERSION}/${RACE_RESOURCE}`,
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
        // Something happened in setting up the request that triggered an Error
        console.log('requete erreur : ' + error);
        res.status(500).send('The server encountered an unexpected condition which prevented it from fulfilling the request.')
      }
    });
});


module.exports = router;
import logging
import json
import datetime
from django.views.generic.base import TemplateView
from django.http import HttpResponse, HttpResponseBadRequest
from django.views.decorators.http import require_POST
from django.shortcuts import get_object_or_404
from django.utils.translation import ugettext as _
from django.views.decorators.http import require_http_methods
from django.http import HttpResponseNotAllowed

from rest_framework import viewsets
from colloquialisms.models import Sentence
from colloquialisms.serializers import SentenceSerializer




class SentenceViewSet(viewsets.ModelViewSet):
    serializer_class = SentenceSerializer

    def get_queryset(self):
        """
        Optionally restricts the returned sentences to a given language
        by filtering against the origin and destination language query parameters in the URL.
        """
        queryset = Sentence.objects.all().filter(active=True)
        lang_origin = self.request.QUERY_PARAMS.get('lang_origin', None)
        lang_dest = self.request.QUERY_PARAMS.get('lang_dest', None)
        if lang_origin is not None and lang_dest is not None:
            queryset = queryset.filter(language_destination=lang_dest, language_origin=lang_origin)
        return queryset

    # Quick and dirty workaround to disallow deleting existing sentences
    def delete(self, request, *args, **kwargs):
        logging.info(request.DATA)
        return HttpResponseNotAllowed('DELETE')

    # Quick and dirty workaround to disallow editing existing sentences
    def update(self, request, *args, **kwargs):
        logging.info(request.DATA)
        return HttpResponseNotAllowed('PUT')

    def create(self, request, *args, **kwargs):
        logging.info(request.DATA)
        return super(SentenceViewSet, self).create(request, *args, **kwargs)


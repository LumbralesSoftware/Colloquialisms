from django.db import models
from django.core.validators import MaxLengthValidator
from django.db.models.signals import pre_save
from django.dispatch import receiver
from django.conf import settings
from django.utils import timezone


class Sentence(models.Model):
    id = models.AutoField(primary_key=True)
    sentence_origin = models.TextField(max_length=1000, verbose_name="Sencence Origin")
    sentence_destination = models.TextField(max_length=1000, verbose_name="Sencence Destination")
    language_origin = models.CharField(max_length=7, choices=settings.LANGUAGES, default="en")
    language_destination = models.CharField(max_length=7, choices=settings.LANGUAGES, default="es")
    created = models.DateTimeField(verbose_name="Created date", auto_now_add=True)
    active = models.BooleanField(verbose_name="Is this sentence active?", default=False)

    class Meta:
        ordering = ['-created']

    def __str__(self):
        return unicode(self).encode('utf-8')

    def __unicode__(self):
        return self.sentence_origin

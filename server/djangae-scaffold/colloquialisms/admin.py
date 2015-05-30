from django.contrib import admin
from colloquialisms.models import Sentence

# Register your models here.
class SentenceAdmin(admin.ModelAdmin):
    list_display = ("id", "sentence_origin", "language_origin", "active", "created")
    #ordering = ('-created',)
admin.site.register(Sentence, SentenceAdmin)


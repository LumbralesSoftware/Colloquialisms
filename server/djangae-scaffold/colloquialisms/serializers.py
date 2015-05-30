from rest_framework import serializers
from colloquialisms.models import Sentence

# Serializers define the API representation.
class SentenceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Sentence
        fields = ('id', 'sentence_origin', 'sentence_destination', 'language_origin', 'language_destination', 'created')

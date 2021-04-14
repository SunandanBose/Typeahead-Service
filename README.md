[PUT]  localhost:9200/employee

{
    "settings": {
        "number_of_shards": 1
    },
   "mappings":{
      "properties":{
         "DisplayName": { "type":"text"}
      }
   }
 }

 cat /usr/local/etc/elasticsearch/elasticsearch.yml

 filter query
 {
    "query": {
        "bool": { // A query that matches documents matching boolean combinations of other queries
            "must": [ // must clause (query) must appear in matching documents and will contribute to the score.
                {
                    "match": {
                        "DisplayName": "Daisey"
                    }
                }
            ],
            "filter": [ //filter clause (query) must appear in matching documents. However unlike must the score of the query will be ignored.
                {
                    "term": {
                        "CountryCode": "us" // it is indexed in lower case so always specify the lower case
                    }
                }
            ]
        }
    }
}

For understanding
should => or
must => and
should_not => nor


# Analyzer Working
Analyzers are the special algorithms that determine how a string field in a document is transformed into terms in the inverted index. 

//Only text fields support the analyzer mapping parameter.

Input -> Character filter -> Tokenizer -> Token Filters -> Output

- Character filter : Performs addition, removal, or replacement actions on the input text given to them. To understand it more clearly, if the input string contains a misspelled word and we need to replace it with the correct one, we can use character filters
    - HTML Strip Character Filter : The html_strip character filter strips out HTML elements like <\b> and decodes HTML entities like &\amp;.
    - Mapping Character Filter : The mapping character filter replaces any occurrences of the specified strings with the specified replacements.
    - Pattern Replace Character Filter : The pattern_replace character filter replaces any characters matching a regular expression with the specified replacement.

- Tokenizer : Output of the character filters is passed to the tokenizer, the only required component of the analyzer which generates a list of tokens. Each token contains a String value and position number both indicating the location in the token stream. 

- Token Filters : 

{{- define "DockerConfigJsonB64" }}
{{- $credentials:= printf "%s:%s" .Values.registry.user .Values.registry.pwd | b64enc }}
{{- printf "{ \"auths\": { \"%s\": { \"auth\": \"%s\" } } }" .Values.registry.host $credentials | b64enc }}
{{ end -}}



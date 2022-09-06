ARG STACK_VERSION

FROM docker.elastic.co/elasticsearch/elasticsearch:${STACK_VERSION}

USER root

COPY . /

RUN set -eux; \
    mkdir /state; \
    chown elasticsearch /state; \
    chmod +x /entrypoint.sh

USER elasticsearch:root

ENTRYPOINT ["/entrypoint.sh"]
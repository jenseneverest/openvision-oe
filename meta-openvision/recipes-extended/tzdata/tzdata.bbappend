PV = "2020a"

SRC_URI[tzcode.md5sum] = "f87c3477e85a5c4b00df0def6c6a0055"
SRC_URI[tzcode.sha256sum] = "7d2af7120ee03df71fbca24031ccaf42404752e639196fe93c79a41b38a6d669"
SRC_URI[tzdata.md5sum] = "96a985bb8eeab535fb8aa2132296763a"
SRC_URI[tzdata.sha256sum] = "547161eca24d344e0b5f96aff6a76b454da295dc14ed4ca50c2355043fb899a2"

TZ_PACKAGES_remove = "tzdata-posix tzdata-right"

RPROVIDES_tzdata-posix_remove = "tzdata-posix"
RPROVIDES_tzdata-right_remove = "tzdata-right"

DEFAULT_TIMEZONE = "Europe/London"


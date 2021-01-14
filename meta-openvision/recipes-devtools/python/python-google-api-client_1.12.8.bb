SUMMARY = "Google API Client Library for Python"
DESCRIPTION = "The Google API Client for Python is a client library for accessing the Plus, Moderator, and many other Google APIs."
HOMEPAGE = "http://google.github.io/google-api-python-client/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94023d14f6b58272fd885e4e3f2f08b3"

SRC_URI = "https://github.com/googleapis/google-api-python-client/archive/v${PV}.tar.gz"

SRC_URI[md5sum] = "8537a4a58b7991837f686345de9071f9"
SRC_URI[sha256sum] = "feab1360f0f2fcf8c2f92e02f7a3d16bcbeab11a3eaaae4e515d66196f9b8dd7"

S = "${WORKDIR}/google-api-python-client-${PV}"

inherit setuptools
include python-package-split.inc

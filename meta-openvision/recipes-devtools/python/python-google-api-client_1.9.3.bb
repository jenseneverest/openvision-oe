SUMMARY = "Google API Client Library for Python"
DESCRIPTION = "The Google API Client for Python is a client library for accessing the Plus, Moderator, and many other Google APIs."
HOMEPAGE = "http://google.github.io/google-api-python-client/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94023d14f6b58272fd885e4e3f2f08b3"

SRC_URI = "https://files.pythonhosted.org/packages/31/8d/06ee9dd2f50eb111d2fc19a217a38b25e0f431ef4e0e7efc2efce2d3daf0/google-api-python-client-${PV}.tar.gz"

SRC_URI[md5sum] = "eb5fa1e3f83b659ff978df1346a55576"
SRC_URI[sha256sum] = "220349ce189a85229fc46875d467101318495a4a735c0ff2f165b9bdbc7511a0"

S = "${WORKDIR}/google-api-python-client-${PV}"

inherit setuptools
include python-package-split.inc

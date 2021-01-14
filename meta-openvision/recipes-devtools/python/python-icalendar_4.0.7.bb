SUMMARY = "The icalendar package is a parser/generator of iCalendar files for use with Python."
HOMEPAGE = "http://icalendar.readthedocs.org"
SECTION = "devel/python"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1b2957cd26c589d0defcb357be630e80"

DEPENDS[pkgvarcheck] = "python-pytz python-dateutil"
RDEPENDS_${PN} = "python-pytz python-dateutil"

SRC_URI = "https://files.pythonhosted.org/packages/58/b8/9aa7963f442b2a8bfdfc40eab8bc399c5eaac5711b8919c52122e4903544/icalendar-${PV}.tar.gz"

SRC_URI[md5sum] = "38e8054cbb733c6a58bb992d6d24e7d3"
SRC_URI[sha256sum] = "0fc18d87f66e0b5da84fa731389496cfe18e4c21304e8f6713556b2e8724a7a4"

S = "${WORKDIR}/icalendar-${PV}"

inherit setuptools

include python-package-split.inc

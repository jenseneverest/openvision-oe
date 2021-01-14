SUMMARY  = "A simple Python module to bypass Cloudflare's anti-bot page."
DESCRIPTION = "See https://github.com/Anorov/cloudflare-scrape for more information."
HOMEPAGE = "https://pypi.org/project/cfscrape"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93d4804f061e05530be1a85b24185408"

RDEPENDS_${PN} += "${PYTHONNAMEONLY}-js2py"

SRC_URI = "https://files.pythonhosted.org/packages/a6/3d/12044a9a927559b2fe09d60b1cd6cd4ed1e062b7a28f15c91367b9ec78f1/cfscrape-${PV}.tar.gz"

S = "${WORKDIR}/cfscrape-${PV}"

inherit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "setuptools3", "setuptools", d)}

SRC_URI[md5sum] = "545068ac44efdf087ba39ee08b124a99"
SRC_URI[sha256sum] = "7c5ef94554e0d6ee7de7cd0d42051526e716ce6c0357679ee0b82c49e189e2ef"

include python-package-split.inc

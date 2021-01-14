SUMMARY = "SoCo (Sonos Controller) is a simple library to control Sonos speakers."
HOMEPAGE = "https://pypi.org/project/soco"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=07b0e2ca9ac77cd65cd4edf2e13367ea"

RDEPENDS_${PN} = "${PYTHONNAMEONLY}-requests"

SRC_URI = "https://files.pythonhosted.org/packages/2f/c4/98bcd1d11018e2cec81a3b2855433c2b222c2d157e9440053addb59e7f75/soco-${PV}.tar.gz"

SRC_URI[md5sum] = "be2f86750aed09368b1061c2be2b8e8c"
SRC_URI[sha256sum] = "929d4fae20b32efc08bb9985798c592aa7268162885541513eddbff0a757418f"

S = "${WORKDIR}/soco-${PV}"

inherit ${@bb.utils.contains("PYTHONEXACTVERSION", "python3", "setuptools3", "setuptools", d)}

include python-package-split.inc

# Make clean requires sphinx which we don't have
CLEANBROKEN = "1"

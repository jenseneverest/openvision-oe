DESCRIPTION = "A comprehensive HTTP client library"
HOMEPAGE = "https://code.google.com/p/httplib2/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=41a98bc55b04b2a38acdb5c8ab0ae6b2"

SRCNAME = "httplib2"

SRC_URI = "https://files.pythonhosted.org/packages/98/3f/0769a851fbb0ecc458260055da67d550d3015ebe6b8b861c79ad00147bb9/httplib2-${PV}.tar.gz"

SRC_URI[md5sum] = "0b331f96cdb2ae0e0342d4ea0f5f0502"
SRC_URI[sha256sum] = "8af66c1c52c7ffe1aa5dc4bcd7c769885254b0756e6e69f953c7f0ab49a70ba3"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools python-dir

do_compile_append() {
       python2 -O -m compileall ${W}/build
}

do_install_append() {
	perm_files=`find "${D}${PYTHON_SITEPACKAGES_DIR}/" -name "top_level.txt"`
	for f in $perm_files; do
		chmod 644 "${f}"
	done

	# httplib2 ships its own (outdated?) duplicate of ${sysconfdir}/ssl/certs/ca-certificates.crt
	# Strip and link to the real thing instead
	rm ${D}${PYTHON_SITEPACKAGES_DIR}/httplib2/cacerts.txt
	ln -s ${sysconfdir}/ssl/certs/ca-certificates.crt ${D}${PYTHON_SITEPACKAGES_DIR}/httplib2/cacerts.txt
}

RDEPENDS_${PN} = "ca-certificates"

RDEPENDS_{PN}-src = "${PN}"

include python-package-split.inc

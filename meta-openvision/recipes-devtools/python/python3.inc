SUMMARY = "The Python Programming Language"
HOMEPAGE = "http://www.python.org"
LICENSE = "PSFv2"
SECTION = "devel/python"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b6ec515b22618f55fa07276b897bacea"

# TODO consolidate patch set
SRC_URI[md5sum] = "75c9c268703654aa6f6f2ae67303dde4"
SRC_URI[sha256sum] = "0f0fa8685c1dc1f1dacb0b4e7779796b90aef99dc1fa4967a71b9da7b57d4a28"

# exclude pre-releases for both python 2.x and 3.x
UPSTREAM_CHECK_REGEX = "[Pp]ython-(?P<pver>\d+(\.\d+)+).tar"

CVE_PRODUCT = "python"

PYTHON_MAJMIN = "3.5"
PYTHON_BINABI = "${PYTHON_MAJMIN}m"

S = "${WORKDIR}/Python-${PV}"

inherit autotools bluetooth pkgconfig

EXTRA_OECONF = "\
  --with-threads \
  --with-pymalloc \
  --without-cxx-main \
  --with-signal-module \
  --enable-shared \
  --enable-ipv6=${@bb.utils.contains('DISTRO_FEATURES', 'ipv6', 'yes', 'no', d)} \
"

PACKAGECONFIG[bluetooth] = ",ac_cv_header_bluetooth_bluetooth_h=no ac_cv_header_bluetooth_h=no,${BLUEZ}"

do_install_append () {
	sed -i -e 's:${HOSTTOOLS_DIR}/install:install:g' \
		-e 's:${HOSTTOOLS_DIR}/mkdir:mkdir:g' \
		${D}/${libdir}/python${PYTHON_MAJMIN}/_sysconfigdata.py
}

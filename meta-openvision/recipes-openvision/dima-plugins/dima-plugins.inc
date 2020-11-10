HOMEPAGE = "https://github.com/Dima73/${PLUGINNAME}"

SRC_URI = "git://github.com/Dima73/${PLUGINNAME}.git"

S = "${WORKDIR}/git"

inherit gitpkgv distutils-openplugins

PV = "git${SRCPV}"
PKGV = "git${GITPKGV}"
